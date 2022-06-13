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
import java.text.DecimalFormat;
import java.util.*;

public class Main extends Application {

    /**
     * 游戏的主窗口
     */
    private static Stage mainWindow;

    /**
     * 主游戏体的屏幕场景
     */
    private static Scene mainMenuScene;

    /**
     * 主菜单布局
     */
    private Parent mainMenuLayout;

    /**
     * 得到主菜单布局
     *
     * @return {@link Parent}
     */
    public Parent getMainMenuLayout() {
        return mainMenuLayout;
    }

    /**
     * 得到主菜单场景
     *
     * @return {@link Scene}
     */
    public static Scene getMainMenuScene() {
        return mainMenuScene;
    }

    /**
     * 得到主窗口
     *
     * @return {@link Stage}
     */
    public static Stage getMainWindow() {
        return mainWindow;
    }

    /**
     * 设置主菜单布局
     *
     * @param mainMenuLayout 主菜单布局
     */
    public void setMainMenuLayout(Parent mainMenuLayout) {
        this.mainMenuLayout = mainMenuLayout;
    }

    /**
     * 主菜单设置场景
     *
     * @param mainMenuScene 主菜单场景
     */
    public static void setMainMenuScene(Scene mainMenuScene) {
        Main.mainMenuScene = mainMenuScene;
    }

    public static void setMainWindow(Stage mainWindow) {
        Main.mainWindow = mainWindow;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage menuStage) throws Exception {
        menuStage.setTitle("WORDLE-EX");
        menuStage.setResizable(false);
        menuStage.setAlwaysOnTop(true);

        mainWindow = menuStage;
        mainMenuLayout = FXMLLoader.load(getClass().getResource("resources/menuScene.fxml"));
        mainMenuScene = new Scene(mainMenuLayout, 1280, 800);

        menuStage.setScene(mainMenuScene);
        menuStage.show();
    }

    public static void startNormalMode() throws Exception {
        WordList.PossibleWord = WordList.ReadWord("src/Data/possible_words.txt");
        WordList.LegalWord = WordList.ReadWord("src/Data/allowed_words.txt");
        WordList.AnswerWord = WordList.ReadWord("src/Data/possible_words.txt");
        Word testword = new Word();
        ArrayList<String> list = new ArrayList<>(WordList.AnswerWord);
        int ansIdx = new Random().nextInt(list.size());
        String ans = list.get(ansIdx);

        System.out.println(ans);

        AniLetter[] aniLetters = new AniLetter[5];

        AnchorPane pane = new AnchorPane();


        Button button = new Button("测试");
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
                                if (Word.CheckInList(testword.WordContent.toString())) {
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
                                    status = testword.getState();
                                    if (status == 0) {
                                        System.out.println("you win");
                                    }
                                    if (line == 6) {
                                        System.out.println("you lose");
                                    }
                                    for (int i = 0; i < 5; i++) {
                                        testword.RemoveLetter();
                                    }

                                } else {
                                    System.out.println("Not in the list");
                                }

                            } catch (Exception e) {
                                //throw new RuntimeException(e);
                                System.out.println("Not in the list");
                                for (int i = 0; i < 5; i++) {
                                    testword.RemoveLetter();
                                }
                            }
                        } else {
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


        Scene scene = new Scene(pane, 1280, 800);

        mainWindow.setScene(scene);
        mainWindow.setTitle("WORDLE-EX");
        mainWindow.show();
    }

    public static void startAdvanceMode() throws Exception {
        Button button = new Button("测试");
        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(button);
        Parent mainScene = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("resources/advanceScene.fxml")));
        pane.getChildren().add(mainScene);

        Scene scene = new Scene(pane, 1280, 800);

        mainWindow.setScene(scene);
        mainWindow.setTitle("WORDLE-EX");
        mainWindow.show();


        WordList.AnswerWord = WordList.ReadWord("src/Data/possible_words.txt");
        WordList.PossibleWord = WordList.ReadWord("src/Data/allowed_words.txt");
        WordList.LegalWord = WordList.ReadWord("src/Data/allowed_words.txt");
        WordList.WordPrior = WordList.ReadPrior("src/Data/freq_map.json");
        Word testword = new Word();
        ArrayList<String> list = new ArrayList<>(WordList.AnswerWord);
        int ansIdx = new Random().nextInt(list.size());
        String ans = list.get(ansIdx);

        GuessAlgorithm.eNow = GuessAlgorithm.calENow(WordList.PossibleWord);
        GuessAlgorithm.possibilities = WordList.PossibleWord.size();
        GuessAlgorithm.getShowList(WordList.PossibleWord);

        GuessAlgorithm.getWordScore(WordList.LegalWord, WordList.PossibleWord);

        AniString hint = new AniString("TOP Picks    E[Info]    p(word)", Color.WHITE);
        pane.getChildren().add(hint.ft.getNode());
        AnchorPane.setLeftAnchor(hint.ft.getNode(), 900.0);
        AnchorPane.setTopAnchor(hint.ft.getNode(), 120.0);
        hint.ft.play();

        AniString[] recommend = new AniString[5];
        AniString[] recommendInfo = new AniString[5];
        AniString[] recommendPossibility = new AniString[5];

        DecimalFormat df2 = new DecimalFormat("#.##");
        DecimalFormat df6 = new DecimalFormat("#.#####");

        for(int i=0; i<5&&i<GuessAlgorithm.wsList.size(); i++){
            recommend[i] = new AniString(GuessAlgorithm.wsList.get(i).word, Color.WHITE);
            pane.getChildren().add(recommend[i].ft.getNode());
            AnchorPane.setLeftAnchor(recommend[i].ft.getNode(), 900.0);
            AnchorPane.setTopAnchor(recommend[i].ft.getNode(), 180.0 + i * 60.0);
            recommend[i].ft.play();
            recommendInfo[i] = new AniString(df2.format(GuessAlgorithm.wsList.get(i).entropy), Color.WHITE);
            pane.getChildren().add(recommendInfo[i].ft.getNode());
            AnchorPane.setLeftAnchor(recommendInfo[i].ft.getNode(), 900.0 + 150.0);
            AnchorPane.setTopAnchor(recommendInfo[i].ft.getNode(), 180.0 + i * 60.0);
            recommendInfo[i].ft.play();
            recommendPossibility[i] = new AniString(df6.format(GuessAlgorithm.wsList.get(i).possible), Color.WHITE);
            pane.getChildren().add(recommendPossibility[i].ft.getNode());
            AnchorPane.setLeftAnchor(recommendPossibility[i].ft.getNode(), 900.0 + 240.0);
            AnchorPane.setTopAnchor(recommendPossibility[i].ft.getNode(), 180.0 + i * 60.0);
            recommendPossibility[i].ft.play();
        }

        AniLetter[] aniLetters = new AniLetter[5];
        ArrayList<AniString> aniStrings = new ArrayList<>();


        aniStrings.add(new AniString("Possibilities:", Color.WHITE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.add(new AniString("" + GuessAlgorithm.possibilities, Color.WHITE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0  + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.add(new AniString("/ E:", Color.SKYBLUE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0  + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        // 保留小数点后两位

        aniStrings.add(new AniString("" + df2.format(GuessAlgorithm.eNow), Color.SKYBLUE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 120  + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.clear();

        button.setOnKeyPressed(new EventHandler<KeyEvent>() {
            private int index = 0;
            private int line = 0;

            private int leftLine = 0;
            private int rightLine = 0;

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
                        AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.0);
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
                                if (Word.CheckInList(testword.WordContent.toString())) {
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
                                    status = testword.getState();
                                    if (status == 0) {
                                        System.out.println("you win");
                                    }
                                    if (line == 6) {
                                        System.out.println("you lose");
                                    }
                                    WordList.PossibleWord=GuessAlgorithm.updatePossibleWord(WordList.PossibleWord, testword.getState(), testword.WordContent.toString());
                                    GuessAlgorithm.possibilities = WordList.PossibleWord.size();
                                    double newE = GuessAlgorithm.calENow(WordList.PossibleWord);
                                    double info = GuessAlgorithm.eNow - newE;

                                    AniString infoString = new AniString(df2.format(info) + "bits", Color.WHITE);
                                    pane.getChildren().add(infoString.ft.getNode());
                                    AnchorPane.setLeftAnchor(infoString.ft.getNode(), 800.0);
                                    AnchorPane.setTopAnchor(infoString.ft.getNode(), 125.0 + leftLine * 60.0);
                                    infoString.ft.play();

                                    GuessAlgorithm.eNow = newE ;
                                    leftLine++;
                                    aniStrings.add(new AniString("Possibilities:", Color.WHITE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.add(new AniString("" + GuessAlgorithm.possibilities , Color.WHITE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0  + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.add(new AniString("/ E:", Color.SKYBLUE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0  + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    // 保留小数点后两位
                                    DecimalFormat df = new DecimalFormat("#.00");
                                    aniStrings.add(new AniString("" + df.format(GuessAlgorithm.eNow), Color.SKYBLUE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 120  + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.clear();

                                    GuessAlgorithm.getWordScore(WordList.LegalWord, WordList.PossibleWord);
                                    for(int i=0; i<5&&i<GuessAlgorithm.wsList.size(); i++){
                                        System.out.println(GuessAlgorithm.wsList.get(i).word+" "+GuessAlgorithm.wsList.get(i).entropy + " " + GuessAlgorithm.wsList.get(i).possible + " " + GuessAlgorithm.wsList.get(i).score);
                                    }


                                    for (int i = 0; i < 5; i++) {
                                        testword.RemoveLetter();
                                        pane.getChildren().remove(recommend[i].ft.getNode());
                                        pane.getChildren().remove(recommendInfo[i].ft.getNode());
                                        pane.getChildren().remove(recommendPossibility[i].ft.getNode());
                                        AniString fadeRecommend = new AniString(recommend[i].string.getText(), Color.WHITE);
                                        pane.getChildren().add(fadeRecommend.ft2.getNode());
                                        AnchorPane.setLeftAnchor(fadeRecommend.ft2.getNode(), 900.0);
                                        AnchorPane.setTopAnchor(fadeRecommend.ft2.getNode(), 180 + i * 60.0);
                                        fadeRecommend.ft2.play();
                                        AniString fadeRecommendInfo = new AniString(recommendInfo[i].string.getText(), Color.WHITE);
                                        pane.getChildren().add(fadeRecommendInfo.ft2.getNode());
                                        AnchorPane.setLeftAnchor(fadeRecommendInfo.ft2.getNode(), 900.0 + 150);
                                        AnchorPane.setTopAnchor(fadeRecommendInfo.ft2.getNode(), 180 + i * 60.0);
                                        fadeRecommendInfo.ft2.play();
                                        AniString fadeRecommendPossibility = new AniString(recommendPossibility[i].string.getText(), Color.WHITE);
                                        pane.getChildren().add(fadeRecommendPossibility.ft2.getNode());
                                        AnchorPane.setLeftAnchor(fadeRecommendPossibility.ft2.getNode(), 900.0 + 240);
                                        AnchorPane.setTopAnchor(fadeRecommendPossibility.ft2.getNode(), 180 + i * 60.0);
                                        fadeRecommendPossibility.ft2.play();
                                    }

                                    for(int i=0; i<5&&i<GuessAlgorithm.wsList.size(); i++){
                                        recommend[i] = new AniString(GuessAlgorithm.wsList.get(i).word, Color.WHITE);
                                        pane.getChildren().add(recommend[i].ft.getNode());
                                        AnchorPane.setLeftAnchor(recommend[i].ft.getNode(), 900.0);
                                        AnchorPane.setTopAnchor(recommend[i].ft.getNode(), 180.0 + i * 60.0);
                                        recommend[i].ft.play();
                                        recommendInfo[i] = new AniString(df2.format(GuessAlgorithm.wsList.get(i).entropy), Color.WHITE);
                                        pane.getChildren().add(recommendInfo[i].ft.getNode());
                                        AnchorPane.setLeftAnchor(recommendInfo[i].ft.getNode(), 900.0 + 150.0);
                                        AnchorPane.setTopAnchor(recommendInfo[i].ft.getNode(), 180.0 + i * 60.0);
                                        recommendInfo[i].ft.play();
                                        recommendPossibility[i] = new AniString(df6.format(GuessAlgorithm.wsList.get(i).possible), Color.WHITE);
                                        pane.getChildren().add(recommendPossibility[i].ft.getNode());
                                        AnchorPane.setLeftAnchor(recommendPossibility[i].ft.getNode(), 900.0 + 240.0);
                                        AnchorPane.setTopAnchor(recommendPossibility[i].ft.getNode(), 180.0 + i * 60.0);
                                        recommendPossibility[i].ft.play();
                                    }

                                } else {
                                    System.out.println("Not in the list");
                                }

                            } catch (Exception e) {
                                //throw new RuntimeException(e);
                                System.out.println("Not in the list");
                                for (int i = 0; i < 5; i++) {
                                    testword.RemoveLetter();
                                }
                            }
                        } else {
                            System.out.println("not enough letter!");
                        }
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }
        });
    }

    public static void startAIShowMode() throws Exception {
        System.out.println("start aishow mode");
        Button button = new Button("测试");
        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(button);
        Parent mainScene = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("resources/advanceScene.fxml")));
        pane.getChildren().add(mainScene);

        Scene scene = new Scene(pane, 1280, 800);

        mainWindow.setScene(scene);
        mainWindow.setTitle("WORDLE-EX");
        mainWindow.show();


        WordList.AnswerWord = WordList.ReadWord("src/Data/possible_words.txt");
        WordList.PossibleWord = WordList.ReadWord("src/Data/allowed_words.txt");
        WordList.LegalWord = WordList.ReadWord("src/Data/allowed_words.txt");
        WordList.WordPrior = WordList.ReadPrior("src/Data/freq_map.json");
        ArrayList<String> list = new ArrayList<>(WordList.AnswerWord);
        int ansIdx = new Random().nextInt(list.size());
        String ans = list.get(ansIdx);

        GuessAlgorithm.eNow = GuessAlgorithm.calENow(WordList.PossibleWord);
        GuessAlgorithm.possibilities = WordList.PossibleWord.size();
        GuessAlgorithm.getShowList(WordList.PossibleWord);

        GuessAlgorithm.getWordScore(WordList.LegalWord, WordList.PossibleWord);
        System.out.println(GuessAlgorithm.wsList.get(0).word);
        Word testword = new Word(GuessAlgorithm.wsList.get(0).word);
        System.out.println("Guess Word:" + testword.WordContent);


        AniString hint = new AniString("TOP Picks    E[Info]    p(word)", Color.WHITE);
        pane.getChildren().add(hint.ft.getNode());
        AnchorPane.setLeftAnchor(hint.ft.getNode(), 900.0);
        AnchorPane.setTopAnchor(hint.ft.getNode(), 120.0);
        hint.ft.play();

        AniString[] recommend = new AniString[5];
        AniString[] recommendInfo = new AniString[5];
        AniString[] recommendPossibility = new AniString[5];

        DecimalFormat df2 = new DecimalFormat("#.##");
        DecimalFormat df6 = new DecimalFormat("#.#####");

        for(int i=0; i<5&&i<GuessAlgorithm.wsList.size(); i++){
            recommend[i] = new AniString(GuessAlgorithm.wsList.get(i).word, Color.WHITE);
            pane.getChildren().add(recommend[i].ft.getNode());
            AnchorPane.setLeftAnchor(recommend[i].ft.getNode(), 900.0);
            AnchorPane.setTopAnchor(recommend[i].ft.getNode(), 180.0 + i * 60.0);
            recommend[i].ft.play();
            recommendInfo[i] = new AniString(df2.format(GuessAlgorithm.wsList.get(i).entropy), Color.WHITE);
            pane.getChildren().add(recommendInfo[i].ft.getNode());
            AnchorPane.setLeftAnchor(recommendInfo[i].ft.getNode(), 900.0 + 150.0);
            AnchorPane.setTopAnchor(recommendInfo[i].ft.getNode(), 180.0 + i * 60.0);
            recommendInfo[i].ft.play();
            recommendPossibility[i] = new AniString(df6.format(GuessAlgorithm.wsList.get(i).possible), Color.WHITE);
            pane.getChildren().add(recommendPossibility[i].ft.getNode());
            AnchorPane.setLeftAnchor(recommendPossibility[i].ft.getNode(), 900.0 + 240.0);
            AnchorPane.setTopAnchor(recommendPossibility[i].ft.getNode(), 180.0 + i * 60.0);
            recommendPossibility[i].ft.play();
        }

        AniLetter[] aniLetters = new AniLetter[5];
        ArrayList<AniString> aniStrings = new ArrayList<>();

        AniString tipString = new AniString("The Answer:", Color.WHITE);
        pane.getChildren().add(tipString.ft.getNode());
        AnchorPane.setLeftAnchor(tipString.ft.getNode(), 50.0);
        AnchorPane.setTopAnchor(tipString.ft.getNode(), 600.0);
        tipString.ft.play();

        AniString ansString = new AniString(ans, Color.GREEN);
        pane.getChildren().add(ansString.ft.getNode());
        AnchorPane.setLeftAnchor(ansString.ft.getNode(), 50.0);
        AnchorPane.setTopAnchor(ansString.ft.getNode(), 650.0);
        ansString.ft.play();

        AniString tipString2 = new AniString("Press Enter To Show Next Step", Color.GREY);
        pane.getChildren().add(tipString2.ft.getNode());
        AnchorPane.setLeftAnchor(tipString2.ft.getNode(), 50.0);
        AnchorPane.setTopAnchor(tipString2.ft.getNode(), 700.0);
        tipString2.ft.play();

        aniStrings.add(new AniString("Possibilities:", Color.WHITE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.add(new AniString("" + GuessAlgorithm.possibilities , Color.WHITE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0  + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.add(new AniString("/ E:", Color.SKYBLUE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0  + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        // 保留小数点后两位

        aniStrings.add(new AniString("" + df2.format(GuessAlgorithm.eNow), Color.SKYBLUE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 120  + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.clear();

        ArrayList<AniString> infoWord = new ArrayList<>();
        for(int i=0; i<5; i++){
            infoWord.add(new AniString(GuessAlgorithm.PossibleWordChance.get(i).word, Color.WHITE));
        }
        for(int i=0; i<5; i++){
            infoWord.add(new AniString(GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size()-6+i).word, Color.WHITE));
        }
        for (int i=0; i<infoWord.size(); i++){
            pane.getChildren().add(infoWord.get(i).ft.getNode());
            AnchorPane.setLeftAnchor(infoWord.get(i).ft.getNode(), 450.0 + (i/5) * 400.0);
            AnchorPane.setTopAnchor(infoWord.get(i).ft.getNode(), 500 + (i%5) * 60.0);
            infoWord.get(i).ft.play();
        }
        ArrayList<AniRectangular> infoChance = new ArrayList<>();
        for(int i=0; i<5; i++){
            infoChance.add(new AniRectangular(300*GuessAlgorithm.PossibleWordChance.get(i).fill, 30.0));
          //  System.out.println(GuessAlgorithm.PossibleWordChance.get(i).fill);
        }
        for(int i=0; i<5; i++){
            infoChance.add(new AniRectangular( 300*GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size()-6+i).fill, 30.0));
           // System.out.println(GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size()-6+i).fill);
        }
        for (int i=0; i<infoChance.size(); i++){
            pane.getChildren().add(infoChance.get(i).ft.getNode());
            AnchorPane.setLeftAnchor(infoChance.get(i).ft.getNode(), 450 + 75.0 + (i/5) * 400.0);
            AnchorPane.setTopAnchor(infoChance.get(i).ft.getNode(), 500 +(i%5) * 60.0);
            infoChance.get(i).ft.play();
        }


        button.setOnKeyPressed(new EventHandler<KeyEvent>() {
            private int index = 0;
            private int line = 0;

            private int leftLine = 0;
            private int rightLine = 0;

            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode kCode = keyEvent.getCode();
                System.out.println(kCode.getName());
                char toAddLetter;
                try {

                    if (kCode == KeyCode.ENTER) {
                        if (testword.letters.size() == 5) {
                            try {
                                int status;
                                for (index=0;index<5;index++) {
                                    aniLetters[index] = new AniLetter((char)(testword.letters.get(index).letterContent-32)+"");
                                    pane.getChildren().add(aniLetters[index].ft.getNode());
                                    AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
                                    AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.0);
                                    aniLetters[index].ft.play();
                                }
                                if (Word.CheckInList(testword.WordContent.toString())) {
                                    index = 0;
                                    line++;
                                    testword.CheckAns(ans);
                                 //   System.out.println(testword.ShowColor());
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
                                    status = testword.getState();
                                    if (status == 0) {
                                        System.out.println("you win");
                                    }
                                    if (line == 6) {
                                        System.out.println("you lose");
                                    }
                                    WordList.PossibleWord=GuessAlgorithm.updatePossibleWord(WordList.PossibleWord, testword.getState(), testword.WordContent.toString());
                                    GuessAlgorithm.possibilities = WordList.PossibleWord.size();
                                    double newE = GuessAlgorithm.calENow(WordList.PossibleWord);
                                    double info = GuessAlgorithm.eNow - newE;

                                    AniString infoString = new AniString(df2.format(info) + "bits", Color.WHITE);
                                    pane.getChildren().add(infoString.ft.getNode());
                                    AnchorPane.setLeftAnchor(infoString.ft.getNode(), 800.0);
                                    AnchorPane.setTopAnchor(infoString.ft.getNode(), 125.0 + leftLine * 60.0);
                                    infoString.ft.play();

                                    GuessAlgorithm.eNow = newE ;
                                    leftLine++;
                                    aniStrings.add(new AniString("Possibilities:", Color.WHITE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.add(new AniString("" + GuessAlgorithm.possibilities , Color.WHITE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0  + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.add(new AniString("/ E:", Color.SKYBLUE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0  + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    // 保留小数点后两位
                                    DecimalFormat df = new DecimalFormat("#.00");
                                    aniStrings.add(new AniString("" + df.format(GuessAlgorithm.eNow), Color.SKYBLUE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 120  + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.clear();

                                    GuessAlgorithm.getWordScore(WordList.LegalWord, WordList.PossibleWord);
                                  /*  for(int i=0; i<5&&i<GuessAlgorithm.wsList.size(); i++){
                                        System.out.println(GuessAlgorithm.wsList.get(i).word+" "+GuessAlgorithm.wsList.get(i).entropy + " " + GuessAlgorithm.wsList.get(i).possible + " " + GuessAlgorithm.wsList.get(i).score);
                                    }*/

                                    for (int i = 0; i < 5; i++) {
                                        testword.RemoveLetter();
                                        pane.getChildren().remove(recommend[i].ft.getNode());
                                        pane.getChildren().remove(recommendInfo[i].ft.getNode());
                                        pane.getChildren().remove(recommendPossibility[i].ft.getNode());
                                        AniString fadeRecommend = new AniString(recommend[i].string.getText(), Color.WHITE);
                                        pane.getChildren().add(fadeRecommend.ft2.getNode());
                                        AnchorPane.setLeftAnchor(fadeRecommend.ft2.getNode(), 900.0);
                                        AnchorPane.setTopAnchor(fadeRecommend.ft2.getNode(), 180 + i * 60.0);
                                        fadeRecommend.ft2.play();
                                        AniString fadeRecommendInfo = new AniString(recommendInfo[i].string.getText(), Color.WHITE);
                                        pane.getChildren().add(fadeRecommendInfo.ft2.getNode());
                                        AnchorPane.setLeftAnchor(fadeRecommendInfo.ft2.getNode(), 900.0 + 150);
                                        AnchorPane.setTopAnchor(fadeRecommendInfo.ft2.getNode(), 180 + i * 60.0);
                                        fadeRecommendInfo.ft2.play();
                                        AniString fadeRecommendPossibility = new AniString(recommendPossibility[i].string.getText(), Color.WHITE);
                                        pane.getChildren().add(fadeRecommendPossibility.ft2.getNode());
                                        AnchorPane.setLeftAnchor(fadeRecommendPossibility.ft2.getNode(), 900.0 + 240);
                                        AnchorPane.setTopAnchor(fadeRecommendPossibility.ft2.getNode(), 180 + i * 60.0);
                                        fadeRecommendPossibility.ft2.play();
                                    }
                                    for(int i=0; i<5; i++){
                                        testword.AddLetter(GuessAlgorithm.wsList.get(0).word.charAt(i));
                                       // System.out.println("wtf:"+testword.WordContent);
                                    }
                                    for(int i=0; i<5&&i<GuessAlgorithm.wsList.size(); i++){
                                        recommend[i] = new AniString(GuessAlgorithm.wsList.get(i).word, Color.WHITE);
                                        pane.getChildren().add(recommend[i].ft.getNode());
                                        AnchorPane.setLeftAnchor(recommend[i].ft.getNode(), 900.0);
                                        AnchorPane.setTopAnchor(recommend[i].ft.getNode(), 180.0 + i * 60.0);
                                        recommend[i].ft.play();
                                        recommendInfo[i] = new AniString(df2.format(GuessAlgorithm.wsList.get(i).entropy), Color.WHITE);
                                        pane.getChildren().add(recommendInfo[i].ft.getNode());
                                        AnchorPane.setLeftAnchor(recommendInfo[i].ft.getNode(), 900.0 + 150.0);
                                        AnchorPane.setTopAnchor(recommendInfo[i].ft.getNode(), 180.0 + i * 60.0);
                                        recommendInfo[i].ft.play();
                                        recommendPossibility[i] = new AniString(df6.format(GuessAlgorithm.wsList.get(i).possible), Color.WHITE);
                                        pane.getChildren().add(recommendPossibility[i].ft.getNode());
                                        AnchorPane.setLeftAnchor(recommendPossibility[i].ft.getNode(), 900.0 + 240.0);
                                        AnchorPane.setTopAnchor(recommendPossibility[i].ft.getNode(), 180.0 + i * 60.0);
                                        recommendPossibility[i].ft.play();
                                    }

                                    System.out.println("chancesize"+infoChance.size());

                                    for(int i=0; i<infoChance.size(); i++){
                                        pane.getChildren().remove(infoChance.get(i).ft.getNode());
                                    }

                                    System.out.println("wordsize"+infoWord.size());
                                    for (int i=0; i<infoWord.size(); i++){
                                        pane.getChildren().remove(infoWord.get(i).ft.getNode());
                                    }

                                    System.out.println("clear");

                                    GuessAlgorithm.getShowList(WordList.PossibleWord);

                                    infoWord.clear();

                                    for(int i=0; i<5&&i<GuessAlgorithm.PossibleWordChance.size(); i++){
                                        infoWord.add(new AniString(GuessAlgorithm.PossibleWordChance.get(i).word, Color.WHITE));
                                    }
                                    if(GuessAlgorithm.PossibleWordChance.size()>5)
                                    for(int i=0; i<5; i++){
                                        infoWord.add(new AniString(GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size()-6+i).word, Color.WHITE));
                                    }

                                    for (int i=0; i<infoWord.size(); i++){
                                        pane.getChildren().add(infoWord.get(i).ft.getNode());
                                        AnchorPane.setLeftAnchor(infoWord.get(i).ft.getNode(), 450.0 + (i/5) * 400.0);
                                        AnchorPane.setTopAnchor(infoWord.get(i).ft.getNode(), 500 + (i%5) * 60.0);
                                        infoWord.get(i).ft.play();
                                    }

                                    infoChance.clear();

                                    for(int i=0; i<5&&i<GuessAlgorithm.PossibleWordChance.size(); i++){
                                        infoChance.add(new AniRectangular(300*GuessAlgorithm.PossibleWordChance.get(i).fill, 30.0));
                                //        System.out.println(GuessAlgorithm.PossibleWordChance.get(i).fill);
                                    }
                                    if(GuessAlgorithm.PossibleWordChance.size()>5)
                                    for(int i=0; i<5; i++){
                                        infoChance.add(new AniRectangular( 300*GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size()-6+i).fill, 30.0));
                                 //       System.out.println(GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size()-6+i).fill);
                                    }
                                    for (int i=0; i<infoChance.size(); i++){
                                        pane.getChildren().add(infoChance.get(i).ft.getNode());
                                        AnchorPane.setLeftAnchor(infoChance.get(i).ft.getNode(), 450 + 75.0 + (i/5) * 400.0);
                                        AnchorPane.setTopAnchor(infoChance.get(i).ft.getNode(), 500 +(i%5) * 60.0);
                                        infoChance.get(i).ft.play();
                                    }

                                } else {
                                    System.out.println("Not in the list");
                                }

                            } catch (Exception e) {
                                //throw new RuntimeException(e);
                                System.out.println("Not in the list");
                                for (int i = 0; i < 5; i++) {
                                    testword.RemoveLetter();
                                }
                            }
                        } else {
                            System.out.println("not enough letter!");
                        }
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }
        });
    }

    public static void backMainMenu() throws Exception {
        mainWindow.setScene(mainMenuScene);
        mainWindow.setTitle("WORDLE-EX");
        mainWindow.show();
    }

}
