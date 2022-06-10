import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage menuStage) throws Exception {

        WordList.PossibleWord = WordList.ReadWord("src/Data/possible_words.txt");
        WordList.LegalWord = WordList.ReadWord("src/Data/allowed_words.txt");
        Word testword = new Word();
        String ans = "about";

        AniLetter[] aniLetters = new AniLetter[5];

        AnchorPane pane = new AnchorPane();


        Button button = new Button("≤‚ ‘");
        button.setOnKeyPressed(new EventHandler<KeyEvent>() {
            private int index = 0;
            private int line = 0;

            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode kCode = keyEvent.getCode();
                System.out.println(kCode.getName());
                char toAddLetter;
                try {
                    if (kCode.isLetterKey() && index < 5) {
                        toAddLetter = (char) (kCode.getCode() + 32);
                        testword.AddLetter(toAddLetter);
                        aniLetters[index] = new AniLetter(keyEvent.getText().toUpperCase(Locale.ROOT));
                        pane.getChildren().add(aniLetters[index].ft.getNode());
                        AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
                        AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
                        aniLetters[index].ft.play();
                        index += 1;
                        System.out.println(testword.WordContent);
                    }
                    if (kCode == KeyCode.BACK_SPACE && index >= 1) {
                        testword.RemoveLetter();
                        pane.getChildren().remove(aniLetters[index - 1].ft.getNode());
                        index -= 1;
                    }
                    if (kCode == KeyCode.ENTER) {
                        if (testword.letters.size() == 5) {
                            try {
                                int status;
                                if(Word.CheckInList(testword.WordContent.toString())){
                                index = 0;
                                line++;
                                testword.CheckAns(ans);
                                System.out.println(testword.ShowColor());
                                for (int i = 0; i < 5; i++) {
                                    if (testword.letters.get(i).letterColor == LetterColor.Green) {
                                        aniLetters[i].text.setFill(Color.GREEN);
                                    }
                                    if (testword.letters.get(i).letterColor == LetterColor.Yellow) {
                                        aniLetters[i].text.setFill(Color.YELLOW);
                                    }
                                    if (testword.letters.get(i).letterColor == LetterColor.Grey) {
                                        aniLetters[i].text.setFill(Color.BLACK);
                                    }
                                }
                                status=testword.getState();
                                if(status==0){
                                    System.out.println("you win");
                                }
                                if(line==6){
                                    System.out.println("you lose");
                                }
                                for (int i = 0; i < 5; i++) {
                                    testword.RemoveLetter();
                                }

                                }
                                else {
                                    System.out.println("Not in list");
                                }

                            } catch (Exception e) {
                                //throw new RuntimeException(e);
                                System.out.println("Not in the list");
                                for (int i = 0; i < 5; i++) {
                                    testword.RemoveLetter();
                                }
                            }
                        }
                        else{
                            System.out.println("not enough letter!");
                        }
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }
        });
        pane.getChildren().add(button);


        Parent mainScene = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("resources/mainScene.fxml")));
        pane.getChildren().add(mainScene);


        Scene scene = new Scene(pane, 1280, 720);

        menuStage.setScene(scene);
        menuStage.setTitle("WORDLE-EX");
        menuStage.show();
    }
}
