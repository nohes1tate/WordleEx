import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * ������Ϸ������
 *
 * @author ���濵
 * @author ������
 * @author ��ط��
 * @date 2022/06/16
 */
public class Main extends Application {

    /**
     * ��Ϸ��������
     */
    private static Stage mainWindow;

    /**
     * ����Ϸ�����Ļ����
     */
    private static Scene mainMenuScene;

    /**
     * ��ȡ��Ϸ������
     *
     * @return {@link Stage}
     */
    public static Stage getMainWindow() {
        return mainWindow;
    }

    /**
     * ���˵����ó���
     *
     * @param mainMenuScene ���˵�����
     */
    public static void setMainMenuScene(Scene mainMenuScene) {
        Main.mainMenuScene = mainMenuScene;
    }

    /**
     * ����ѭ���ı���
     */
    private static int index = 0;

    /**
     * ��¼��������
     */
    private static int line = 0;

    /**
     * ������ʾ�����Ϣ
     */
    private static int leftLine = 0;

    /**
     * ����
     */
    private static AnchorPane pane = new AnchorPane();

    /**
     * ������ĸ����
     */
    private static AniLetter[] aniLetters = new AniLetter[5];

    /**
     * ��ǰ����
     */
    private static Word testword = new Word();

    /**
     * ��Ŀ��
     */
    private static String ans;

    /**
     * �Ƽ�����
     */
    private static AniString[] recommend = new AniString[5];

    /**
     * �Ƽ����ʵ������ṩ��Ϣ
     */
    private static AniString[] recommendInfo = new AniString[5];

    /**
     * �Ƽ�����Ϊ��ȷ�𰸵Ŀ�����
     */
    private static AniString[] recommendPossibility = new AniString[5];

    /**
     * �ַ�������
     */
    private static ArrayList<AniString> aniStrings = new ArrayList<>();

    /**
     * ��ʽ��С��
     */
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    /**
     * ��ʽ��С��
     */
    private static DecimalFormat df6 = new DecimalFormat("#.#####");

    /**
     * ҳ�������
     */
    private static MenuScene Controller;
    /**
     * ҳ�������
     */
    private static AdvanceScene advanceController;
    /**
     * ��¼��Ϸ�Ƿ����
     */
    private static boolean gameIsOver = false;

    /**
     * ��Ϸ����������
     *
     * @param args arg��Ϸ
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * ��Ϸ
     *
     * @param menuStage ��Ϸ������
     * @throws Exception �쳣
     */
    @Override
    public void start(Stage menuStage) throws Exception {

        menuStage.setTitle("WORDLE-EX");
        menuStage.setResizable(false);
        menuStage.setAlwaysOnTop(true);

        mainWindow = menuStage;
        Parent mainMenuLayout = FXMLLoader.load(getClass().getResource("resources/menuScene.fxml"));
        mainMenuScene = new Scene(mainMenuLayout, 1280, 800);

        menuStage.setScene(mainMenuScene);
        menuStage.show();
    }

    /**
     * �������ҳ��
     */
    public static void toRuleView() {
        try {
            Parent ruleLayout = FXMLLoader.load(Main.class.getResource("resources/basicRule.fxml"));
            Scene ruleScene = new Scene(ruleLayout, 1280, 800);
            mainWindow.setScene(ruleScene);
            mainWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ����NormalMode����
     */
    public static void toNormalRule(){
        try {
            Parent ruleLayout = FXMLLoader.load(Main.class.getResource("resources/NormalMode.fxml"));
            Scene ruleScene = new Scene(ruleLayout, 1280, 800);
            mainWindow.setScene(ruleScene);
            mainWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ����AdvancdMode����ҳ��
     */
    public static void toAdvanceRule(){
        try {
            Parent ruleLayout = FXMLLoader.load(Main.class.getResource("resources/AdvanceMode.fxml"));
            Scene ruleScene = new Scene(ruleLayout, 1280, 800);
            mainWindow.setScene(ruleScene);
            mainWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ����AIRule����ҳ��
     */
    public static void toAIRule() {
        try {
            Parent ruleLayout = FXMLLoader.load(Main.class.getResource("resources/AIMode.fxml"));
            Scene ruleScene = new Scene(ruleLayout, 1280, 800);
            mainWindow.setScene(ruleScene);
            mainWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ����NormalMode�ķ���
     *
     * @throws Exception �쳣
     */
    public static void startNormalMode() throws Exception {
        gameIsOver = false;
        WordList.PossibleWord = WordList.ReadWord("src/Data/possible_words.txt");
        WordList.LegalWord = WordList.ReadWord("src/Data/allowed_words.txt");
        WordList.AnswerWord = WordList.ReadWord("src/Data/possible_words.txt");

        testword = new Word();
        ArrayList<String> list = new ArrayList<>(WordList.AnswerWord);
        int ansIdx = new Random().nextInt(list.size());
        ans = list.get(ansIdx);

        System.out.println(ans);


        index = 0;

        line = 0;
        pane = new AnchorPane();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("resources/mainScene.fxml"));
        Parent mainScene = loader.load();
        pane.getChildren().add(mainScene);


        Scene scene = new Scene(pane, 1280, 800);

        Controller = loader.getController();

        pane.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent keyEvent) -> {
            KeyCode kCode = keyEvent.getCode();
            System.out.println(kCode.getName());
            char toAddLetter;
            try {
                if (!gameIsOver) {
                    if (kCode.isLetterKey() && index < 5 && line < 6) {
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
                                            Controller.changeButtonColor(testword.letters.get(i).letterContent, 3);
                                        }
                                        if (testword.letters.get(i).letterColor == LetterColor.Yellow) {
                                            aniLetters[i].text.setFill(Color.YELLOW);
                                            Controller.changeButtonColor(testword.letters.get(i).letterContent, 2);
                                        }
                                        if (testword.letters.get(i).letterColor == LetterColor.Grey) {
                                            aniLetters[i].text.setFill(Color.BLACK);
                                            Controller.changeButtonColor(testword.letters.get(i).letterContent, 1);
                                        }

                                    }
                                    status = testword.getState();
                                    if (status == 0) {
                                        System.out.println("you win");
                                        Rectangle recB = new Rectangle();
                                        recB.setFill(Color.BLACK);
                                        recB.setWidth(1280);
                                        recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                                        FadeTransition black = new FadeTransition();
                                        black.setNode(recB);
                                        black.setFromValue(0);
                                        black.setToValue(0.8);
                                        black.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(black.getNode());
                                        AnchorPane.setTopAnchor(black.getNode(), 0.);
                                        AnchorPane.setLeftAnchor(black.getNode(), 0.);
                                        black.play();

                                        FadeTransition win = new FadeTransition();
                                        Text text = new Text("WIN!!");
                                        gameIsOver = true;
                                        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
                                        text.setTextAlignment(TextAlignment.JUSTIFY);
                                        text.setFill(Color.GREEN);
                                        win.setNode(text);
                                        win.setFromValue(0);
                                        win.setToValue(1);
                                        win.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(win.getNode());
                                        AnchorPane.setTopAnchor(win.getNode(), 280.0);
                                        AnchorPane.setLeftAnchor(win.getNode(), 500.0);
                                        win.play();

                                        Button b = new Button();
                                        b.setText("Back to Menu");
                                        b.setLayoutX(200);
                                        b.setLayoutY(50);
                                        b.setPrefWidth(200);
                                        b.setPrefHeight(50);
                                        //�������밴ťʱ�����Ӱ��Ч
                                        b.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#a8a8a8;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        //������뿪��ťʱ�Ƴ���ӰЧ��
                                        b.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        );
                                        AnchorPane.setTopAnchor(b, 400.);
                                        AnchorPane.setLeftAnchor(b, 530.);
                                        pane.getChildren().add(b);
                                        b.setOnMouseClicked(finish -> {
                                            try {
                                                Controller.backToMenu();
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                        });

                                    }
                                    if (line == 6 && !gameIsOver) {
                                        System.out.println("you lose");
                                        System.out.println("you win");
                                        Rectangle recB = new Rectangle();
                                        recB.setFill(Color.BLACK);
                                        recB.setWidth(1280);
                                        recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                                        FadeTransition black = new FadeTransition();
                                        black.setNode(recB);
                                        black.setFromValue(0);
                                        black.setToValue(0.8);
                                        black.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(black.getNode());
                                        AnchorPane.setTopAnchor(black.getNode(), 0.);
                                        AnchorPane.setLeftAnchor(black.getNode(), 0.);
                                        black.play();

                                        FadeTransition win = new FadeTransition();
                                        Text text = new Text("LOSE!!");
                                        gameIsOver = true;
                                        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
                                        text.setTextAlignment(TextAlignment.JUSTIFY);
                                        text.setFill(Color.RED);
                                        win.setNode(text);
                                        win.setFromValue(0);
                                        win.setToValue(1);
                                        win.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(win.getNode());
                                        AnchorPane.setTopAnchor(win.getNode(), 280.0);
                                        AnchorPane.setLeftAnchor(win.getNode(), 500.0);
                                        win.play();

                                        Button b = new Button();
                                        b.setText("Back to Menu");
                                        b.setLayoutX(200);
                                        b.setLayoutY(50);
                                        b.setPrefWidth(200);
                                        b.setPrefHeight(50);
                                        b.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#a8a8a8;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        //������뿪��ťʱ�Ƴ���ӰЧ��
                                        b.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
//                                                        "-fx-border-style:dashed;"+      //���ñ߿���ʽ
//                                                        "-fx-border-width:5;"+           //���ñ߿���
//                                                        "-fx-border-insets:-5"           //���ñ߿����ֵ
                                                        + "-fx-font-size: 20"
                                        );
                                        AnchorPane.setTopAnchor(b, 400.);
                                        AnchorPane.setLeftAnchor(b, 530.);
                                        pane.getChildren().add(b);
                                        b.setOnMouseClicked(finish -> {
                                            try {
                                                Controller.backToMenu();
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                        });
                                    }
                                    for (int i = 0; i < 5; i++) {
                                        testword.RemoveLetter();
                                    }

                                } else {
                                    System.out.println("Not in the list");

                                    Rectangle recB = new Rectangle();
                                    recB.setFill(Color.BLACK);
                                    recB.setWidth(1280);
                                    recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                                    FadeTransition black = new FadeTransition();
                                    black.setNode(recB);
                                    black.setFromValue(0);
                                    black.setToValue(0.2);
                                    black.setCycleCount(2);
                                    black.setAutoReverse(true);
                                    black.setDuration(Duration.seconds(1));


                                    pane.getChildren().add(black.getNode());
                                    AnchorPane.setTopAnchor(black.getNode(), 0.);
                                    AnchorPane.setLeftAnchor(black.getNode(), 0.);
                                    black.play();
                                    black.setOnFinished(finish-> pane.getChildren().remove(black.getNode()));

                                    FadeTransition win = new FadeTransition();
                                    Text text = new Text("Not in Word List!!");
                                    text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 80));
                                    text.setTextAlignment(TextAlignment.JUSTIFY);
                                    text.setFill(Color.YELLOW);
                                    win.setNode(text);
                                    win.setFromValue(0);
                                    win.setToValue(1);
                                    win.setDuration(Duration.seconds(1));
                                    win.setAutoReverse(true);
                                    win.setCycleCount(2);
                                    pane.getChildren().add(win.getNode());
                                    AnchorPane.setTopAnchor(win.getNode(), 300.0);
                                    AnchorPane.setLeftAnchor(win.getNode(), 350.0);
                                    win.play();
                                    win.setOnFinished(finish->{
                                        pane.getChildren().remove(win.getNode());
                                        System.out.println("YES");
                                    });
                                }

                            } catch (Exception e) {
                                //throw new RuntimeException(e);
                                System.out.println(e);
                                for (int i = 0; i < 5; i++) {
                                    testword.RemoveLetter();
                                }
                            }
                        } else {
                            System.out.println(testword.WordContent);
                            System.out.println(testword.letters.size());
                            System.out.println("not enough letter!");
                        }
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        //  Parent mainScene = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("resources/mainScene.fxml")));


        mainWindow.setScene(scene);
        mainWindow.setTitle("WORDLE-EX");
        mainWindow.show();
    }

    /**
     * ����AdvanceMode�ķ���
     *
     * @throws Exception �쳣
     */
    public static void startAdvanceMode() throws Exception {
        gameIsOver = false;
        index = 0;
        line = 0;
        leftLine = 0;
        Button button = new Button("����");
        testword = new Word();
        pane = new AnchorPane();
        pane.getChildren().add(button);
        // Parent mainScene = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("resources/advanceScene.fxml")));


        FXMLLoader loader = new FXMLLoader(Main.class.getResource("resources/advanceScene.fxml"));
        Parent mainScene = loader.load();
        pane.getChildren().add(mainScene);

        Scene scene = new Scene(pane, 1280, 800);

        advanceController = loader.getController();


        mainWindow.setScene(scene);
        mainWindow.setTitle("WORDLE-EX");
        mainWindow.show();


        WordList.AnswerWord = WordList.ReadWord("src/Data/possible_words.txt");
        WordList.PossibleWord = WordList.ReadWord("src/Data/allowed_words.txt");
        WordList.LegalWord = WordList.ReadWord("src/Data/allowed_words.txt");
        WordList.WordPrior = WordList.ReadPrior("src/Data/freq_map.json");

        ArrayList<String> list = new ArrayList<>(WordList.AnswerWord);
        int ansIdx = new Random().nextInt(list.size());
        ans = list.get(ansIdx);

        GuessAlgorithm.eNow = GuessAlgorithm.calENow(WordList.PossibleWord);
        GuessAlgorithm.possibilities = WordList.PossibleWord.size();
        GuessAlgorithm.getShowList(WordList.PossibleWord);

        GuessAlgorithm.getWordScore(WordList.LegalWord, WordList.PossibleWord);

        AniString hint = new AniString("TOP Picks    E[Info]    p(word)", Color.WHITE);
        pane.getChildren().add(hint.ft.getNode());
        AnchorPane.setLeftAnchor(hint.ft.getNode(), 900.0);
        AnchorPane.setTopAnchor(hint.ft.getNode(), 120.0);
        hint.ft.play();

        recommend = new AniString[5];
        recommendInfo = new AniString[5];
        recommendPossibility = new AniString[5];

        df2 = new DecimalFormat("#.##");
        df6 = new DecimalFormat("#.#####");

        for (int i = 0; i < 5 && i < GuessAlgorithm.wsList.size(); i++) {
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

        aniLetters = new AniLetter[5];
        aniStrings = new ArrayList<>();


        aniStrings.add(new AniString("Possibilities:", Color.WHITE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.add(new AniString("" + GuessAlgorithm.possibilities, Color.WHITE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0 + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.add(new AniString("/ E:", Color.SKYBLUE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0 + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        // ����С�������λ

        aniStrings.add(new AniString("" + df2.format(GuessAlgorithm.eNow), Color.SKYBLUE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 120 + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.clear();

        pane.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent keyEvent) -> {

            KeyCode kCode = keyEvent.getCode();
            System.out.println(kCode.getName());
            char toAddLetter;
            try {
                if (!gameIsOver) {
                    if (kCode.isLetterKey() && index < 5 && line < 6) {
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
                    else if (kCode == KeyCode.BACK_SPACE && index >= 1) {
                        testword.RemoveLetter();
                        pane.getChildren().remove(aniLetters[index - 1].ft.getNode());
                        index -= 1;
                    }
                    else if (kCode == KeyCode.ENTER) {
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
                                            advanceController.changeButtonColor(testword.letters.get(i).letterContent, 3);
                                        }
                                        if (testword.letters.get(i).letterColor == LetterColor.Yellow) {
                                            aniLetters[i].text.setFill(Color.YELLOW);
                                            advanceController.changeButtonColor(testword.letters.get(i).letterContent, 2);
                                        }
                                        if (testword.letters.get(i).letterColor == LetterColor.Grey) {
                                            aniLetters[i].text.setFill(Color.BLACK);
                                            System.out.println("changecolorbegin");
                                            advanceController.changeButtonColor(testword.letters.get(i).letterContent, 1);
                                            System.out.println("changecolorend");
                                        }
                                    }
                                    status = testword.getState();

                                    WordList.PossibleWord = GuessAlgorithm.updatePossibleWord(WordList.PossibleWord, testword.getState(), testword.WordContent.toString());
                                    GuessAlgorithm.possibilities = WordList.PossibleWord.size();
                                    double newE = GuessAlgorithm.calENow(WordList.PossibleWord);
                                    double info = GuessAlgorithm.eNow - newE;

                                    AniString infoString = new AniString(df2.format(info) + "bits", Color.WHITE);
                                    pane.getChildren().add(infoString.ft.getNode());
                                    AnchorPane.setLeftAnchor(infoString.ft.getNode(), 800.0);
                                    AnchorPane.setTopAnchor(infoString.ft.getNode(), 125.0 + leftLine * 60.0);
                                    infoString.ft.play();

                                    GuessAlgorithm.eNow = newE;
                                    leftLine++;
                                    aniStrings.add(new AniString("Possibilities:", Color.WHITE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.add(new AniString("" + GuessAlgorithm.possibilities, Color.WHITE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0 + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.add(new AniString("/ E:", Color.SKYBLUE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0 + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    // ����С�������λ
                                    DecimalFormat df = new DecimalFormat("#.00");
                                    aniStrings.add(new AniString("" + df.format(GuessAlgorithm.eNow), Color.SKYBLUE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 120 + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.clear();

                                    GuessAlgorithm.getWordScore(WordList.LegalWord, WordList.PossibleWord);
                                    for (int i = 0; i < 5 && i < GuessAlgorithm.wsList.size(); i++) {
                                        System.out.println(GuessAlgorithm.wsList.get(i).word + " " + GuessAlgorithm.wsList.get(i).entropy + " " + GuessAlgorithm.wsList.get(i).possible + " " + GuessAlgorithm.wsList.get(i).score);
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

                                    for (int i = 0; i < 5 && i < GuessAlgorithm.wsList.size(); i++) {
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
                                    if (status == 0) {
                                        System.out.println("you win");
                                        Rectangle recB = new Rectangle();
                                        recB.setFill(Color.BLACK);
                                        recB.setWidth(1280);
                                        recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                                        FadeTransition black = new FadeTransition();
                                        black.setNode(recB);
                                        black.setFromValue(0);
                                        black.setToValue(0.8);
                                        black.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(black.getNode());
                                        AnchorPane.setTopAnchor(black.getNode(), 0.);
                                        AnchorPane.setLeftAnchor(black.getNode(), 0.);
                                        black.play();

                                        FadeTransition win = new FadeTransition();
                                        Text text = new Text("WIN!!");
                                        gameIsOver = true;
                                        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
                                        text.setTextAlignment(TextAlignment.JUSTIFY);
                                        text.setFill(Color.GREEN);
                                        win.setNode(text);
                                        win.setFromValue(0);
                                        win.setToValue(1);
                                        win.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(win.getNode());
                                        AnchorPane.setTopAnchor(win.getNode(), 280.0);
                                        AnchorPane.setLeftAnchor(win.getNode(), 500.0);
                                        win.play();

                                        Button b = new Button();
                                        b.setText("Back to Menu");
                                        b.setLayoutX(200);
                                        b.setLayoutY(50);
                                        b.setPrefWidth(200);
                                        b.setPrefHeight(50);
                                        b.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#a8a8a8;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        //������뿪��ťʱ�Ƴ���ӰЧ��
                                        b.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
//                                                        "-fx-border-style:dashed;"+      //���ñ߿���ʽ
//                                                        "-fx-border-width:5;"+           //���ñ߿���
//                                                        "-fx-border-insets:-5"           //���ñ߿����ֵ
                                                        + "-fx-font-size: 20"
                                        );
                                        AnchorPane.setTopAnchor(b, 400.);
                                        AnchorPane.setLeftAnchor(b, 530.);
                                        pane.getChildren().add(b);
                                        b.setOnMouseClicked(finish -> {
                                            try {
                                                advanceController.backToMenu();
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                        });
                                    }
                                    if (line == 6 && !gameIsOver) {
                                        System.out.println("you lose");

                                        Rectangle recB = new Rectangle();
                                        recB.setFill(Color.BLACK);
                                        recB.setWidth(1280);
                                        recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                                        FadeTransition black = new FadeTransition();
                                        black.setNode(recB);
                                        black.setFromValue(0);
                                        black.setToValue(0.8);
                                        black.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(black.getNode());
                                        AnchorPane.setTopAnchor(black.getNode(), 0.);
                                        AnchorPane.setLeftAnchor(black.getNode(), 0.);
                                        black.play();

                                        FadeTransition win = new FadeTransition();
                                        Text text = new Text("LOSE!!");
                                        gameIsOver = true;
                                        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
                                        text.setTextAlignment(TextAlignment.JUSTIFY);
                                        text.setFill(Color.RED);
                                        win.setNode(text);
                                        win.setFromValue(0);
                                        win.setToValue(1);
                                        win.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(win.getNode());
                                        AnchorPane.setTopAnchor(win.getNode(), 280.0);
                                        AnchorPane.setLeftAnchor(win.getNode(), 500.0);
                                        win.play();

                                        Button b = new Button();
                                        b.setText("Back to Menu");
                                        b.setLayoutX(200);
                                        b.setLayoutY(50);
                                        b.setPrefWidth(200);
                                        b.setPrefHeight(50);
                                        b.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#a8a8a8;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        //������뿪��ťʱ�Ƴ���ӰЧ��
                                        b.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
//                                                        "-fx-border-style:dashed;"+      //���ñ߿���ʽ
//                                                        "-fx-border-width:5;"+           //���ñ߿���
//                                                        "-fx-border-insets:-5"           //���ñ߿����ֵ
                                                        + "-fx-font-size: 20"
                                        );
                                        AnchorPane.setTopAnchor(b, 400.);
                                        AnchorPane.setLeftAnchor(b, 530.);
                                        pane.getChildren().add(b);
                                        b.setOnMouseClicked(finish -> {
                                            try {
                                                Controller.backToMenu();
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                        });
                                    }

                                } else {
                                    System.out.println("Not in the list");

                                    Rectangle recB = new Rectangle();
                                    recB.setFill(Color.BLACK);
                                    recB.setWidth(1280);
                                    recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                                    FadeTransition black = new FadeTransition();
                                    black.setNode(recB);
                                    black.setFromValue(0);
                                    black.setToValue(0.2);
                                    black.setCycleCount(2);
                                    black.setAutoReverse(true);
                                    black.setDuration(Duration.seconds(1));


                                    pane.getChildren().add(black.getNode());
                                    AnchorPane.setTopAnchor(black.getNode(), 0.);
                                    AnchorPane.setLeftAnchor(black.getNode(), 0.);
                                    black.play();
                                    black.setOnFinished(finish-> pane.getChildren().remove(black.getNode()));

                                    FadeTransition win = new FadeTransition();
                                    Text text = new Text("Not in Word List!!");
                                    text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 80));
                                    text.setTextAlignment(TextAlignment.JUSTIFY);
                                    text.setFill(Color.YELLOW);
                                    win.setNode(text);
                                    win.setFromValue(0);
                                    win.setToValue(1);
                                    win.setDuration(Duration.seconds(1));
                                    win.setAutoReverse(true);
                                    win.setCycleCount(2);
                                    pane.getChildren().add(win.getNode());
                                    AnchorPane.setTopAnchor(win.getNode(), 300.0);
                                    AnchorPane.setLeftAnchor(win.getNode(), 350.0);
                                    win.play();
                                    win.setOnFinished(finish->{
                                        pane.getChildren().remove(win.getNode());
                                        System.out.println("YES");
                                    });
                                }

                            } catch (Exception e) {
                                //throw new RuntimeException(e);
                                System.out.println(e);
                                for (int i = 0; i < 5; i++) {
                                    testword.RemoveLetter();
                                }
                            }
                        } else {
                            System.out.println("not enough letter!");
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
    }

    /**
     * ����AIShowģʽ�ķ���
     *
     * @throws Exception �쳣
     */
    public static void startAIShowMode() throws Exception {
        gameIsOver = false;
        index = 0;
        line = 0;
        System.out.println("start aishow mode");
        AnchorPane pane = new AnchorPane();

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("resources/aiShowScene.fxml"));
        Parent mainScene = loader.load();
        pane.getChildren().add(mainScene);

        Scene scene = new Scene(pane, 1280, 800);

        MenuScene Controller = loader.getController();

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

        for (int i = 0; i < 5 && i < GuessAlgorithm.wsList.size(); i++) {
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
        pane.getChildren().add(aniStrings.get(0).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.add(new AniString("" + GuessAlgorithm.possibilities, Color.WHITE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0 + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.add(new AniString("/ E:", Color.SKYBLUE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0 + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        // ����С�������λ

        aniStrings.add(new AniString("" + df2.format(GuessAlgorithm.eNow), Color.SKYBLUE));
        pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
        AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 120 + aniStrings.size() * 75.0);
        AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0);
        aniStrings.get(aniStrings.size() - 1).ft.play();

        aniStrings.clear();

        ArrayList<AniString> infoWord = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            infoWord.add(new AniString(GuessAlgorithm.PossibleWordChance.get(i).word, Color.WHITE));
        }
        for (int i = 0; i < 5; i++) {
            infoWord.add(new AniString(GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size() - 6 + i).word, Color.WHITE));
        }
        for (int i = 0; i < infoWord.size(); i++) {
            pane.getChildren().add(infoWord.get(i).ft.getNode());
            AnchorPane.setLeftAnchor(infoWord.get(i).ft.getNode(), 450.0 + (i / 5) * 400.0);
            AnchorPane.setTopAnchor(infoWord.get(i).ft.getNode(), 500 + (i % 5) * 60.0);
            infoWord.get(i).ft.play();
        }
        ArrayList<AniRectangular> infoChance = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            infoChance.add(new AniRectangular(300 * GuessAlgorithm.PossibleWordChance.get(i).fill, 30.0));
            //  System.out.println(GuessAlgorithm.PossibleWordChance.get(i).fill);
        }
        for (int i = 0; i < 5; i++) {
            infoChance.add(new AniRectangular(300 * GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size() - 6 + i).fill, 30.0));
            // System.out.println(GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size()-6+i).fill);
        }
        for (int i = 0; i < infoChance.size(); i++) {
            pane.getChildren().add(infoChance.get(i).ft.getNode());
            AnchorPane.setLeftAnchor(infoChance.get(i).ft.getNode(), 450 + 75.0 + (i / 5) * 400.0);
            AnchorPane.setTopAnchor(infoChance.get(i).ft.getNode(), 500 + (i % 5) * 60.0);
            infoChance.get(i).ft.play();
        }

        index = 0;
        line = 0;
        leftLine = 0;


        pane.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent keyEvent) -> {


            KeyCode kCode = keyEvent.getCode();
            System.out.println(kCode.getName());
            try {
                if (!gameIsOver) {
                    if (kCode == KeyCode.ENTER) {
                        if (testword.letters.size() == 5 && line < 6) {
                            try {
                                int status;
                                for (index = 0; index < 5; index++) {
                                    aniLetters[index] = new AniLetter((char) (testword.letters.get(index).letterContent - 32) + "");
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

                                    WordList.PossibleWord = GuessAlgorithm.updatePossibleWord(WordList.PossibleWord, testword.getState(), testword.WordContent.toString());
                                    GuessAlgorithm.possibilities = WordList.PossibleWord.size();
                                    double newE = GuessAlgorithm.calENow(WordList.PossibleWord);
                                    double info = GuessAlgorithm.eNow - newE;

                                    AniString infoString = new AniString(df2.format(info) + "bits", Color.WHITE);
                                    pane.getChildren().add(infoString.ft.getNode());
                                    AnchorPane.setLeftAnchor(infoString.ft.getNode(), 800.0);
                                    AnchorPane.setTopAnchor(infoString.ft.getNode(), 125.0 + leftLine * 60.0);
                                    infoString.ft.play();

                                    GuessAlgorithm.eNow = newE;
                                    leftLine++;
                                    aniStrings.add(new AniString("Possibilities:", Color.WHITE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.add(new AniString("" + GuessAlgorithm.possibilities, Color.WHITE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0 + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.add(new AniString("/ E:", Color.SKYBLUE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0 + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    // ����С�������λ
                                    DecimalFormat df = new DecimalFormat("#.00");
                                    aniStrings.add(new AniString("" + df.format(GuessAlgorithm.eNow), Color.SKYBLUE));
                                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 120 + aniStrings.size() * 75.0);
                                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                                    aniStrings.get(aniStrings.size() - 1).ft.play();

                                    aniStrings.clear();

                                    GuessAlgorithm.getWordScore(WordList.LegalWord, WordList.PossibleWord);

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
                                    for (int i = 0; i < 5; i++) {
                                        testword.AddLetter(GuessAlgorithm.wsList.get(0).word.charAt(i));
                                        // System.out.println("wtf:"+testword.WordContent);
                                    }
                                    for (int i = 0; i < 5 && i < GuessAlgorithm.wsList.size(); i++) {
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

                                    System.out.println("chancesize" + infoChance.size());

                                    for (AniRectangular aniRectangular : infoChance) {
                                        pane.getChildren().remove(aniRectangular.ft.getNode());
                                    }

                                    System.out.println("wordsize" + infoWord.size());
                                    for (AniString aniString : infoWord) {
                                        pane.getChildren().remove(aniString.ft.getNode());
                                    }

                                    System.out.println("clear");

                                    GuessAlgorithm.getShowList(WordList.PossibleWord);

                                    infoWord.clear();

                                    for (int i = 0; i < 5 && i < GuessAlgorithm.PossibleWordChance.size(); i++) {
                                        infoWord.add(new AniString(GuessAlgorithm.PossibleWordChance.get(i).word, Color.WHITE));
                                    }
                                    if (GuessAlgorithm.PossibleWordChance.size() > 5)
                                        for (int i = 0; i < 5; i++) {
                                            infoWord.add(new AniString(GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size() - 6 + i).word, Color.WHITE));
                                        }

                                    for (int i = 0; i < infoWord.size(); i++) {
                                        pane.getChildren().add(infoWord.get(i).ft.getNode());
                                        AnchorPane.setLeftAnchor(infoWord.get(i).ft.getNode(), 450.0 + (i / 5) * 400.0);
                                        AnchorPane.setTopAnchor(infoWord.get(i).ft.getNode(), 500 + (i % 5) * 60.0);
                                        infoWord.get(i).ft.play();
                                    }

                                    infoChance.clear();

                                    for (int i = 0; i < 5 && i < GuessAlgorithm.PossibleWordChance.size(); i++) {
                                        infoChance.add(new AniRectangular(300 * GuessAlgorithm.PossibleWordChance.get(i).fill, 30.0));
                                        //        System.out.println(GuessAlgorithm.PossibleWordChance.get(i).fill);
                                    }
                                    if (GuessAlgorithm.PossibleWordChance.size() > 5)
                                        for (int i = 0; i < 5; i++) {
                                            infoChance.add(new AniRectangular(300 * GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size() - 6 + i).fill, 30.0));
                                            //       System.out.println(GuessAlgorithm.PossibleWordChance.get(GuessAlgorithm.PossibleWordChance.size()-6+i).fill);
                                        }
                                    for (int i = 0; i < infoChance.size(); i++) {
                                        pane.getChildren().add(infoChance.get(i).ft.getNode());
                                        AnchorPane.setLeftAnchor(infoChance.get(i).ft.getNode(), 450 + 75.0 + (i / 5) * 400.0);
                                        AnchorPane.setTopAnchor(infoChance.get(i).ft.getNode(), 500 + (i % 5) * 60.0);
                                        infoChance.get(i).ft.play();
                                    }
                                    if (status == 0) {
                                        System.out.println("you win");

                                        Rectangle recB = new Rectangle();
                                        recB.setFill(Color.BLACK);
                                        recB.setWidth(1280);
                                        recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                                        FadeTransition black = new FadeTransition();
                                        black.setNode(recB);
                                        black.setFromValue(0);
                                        black.setToValue(0.5);
                                        black.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(black.getNode());
                                        AnchorPane.setTopAnchor(black.getNode(), 0.);
                                        AnchorPane.setLeftAnchor(black.getNode(), 0.);
                                        black.play();

                                        FadeTransition win = new FadeTransition();
                                        Text text = new Text("WIN!!");
                                        gameIsOver = true;
                                        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
                                        text.setTextAlignment(TextAlignment.JUSTIFY);
                                        text.setFill(Color.GREEN);
                                        win.setNode(text);
                                        win.setFromValue(0);
                                        win.setToValue(1);
                                        win.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(win.getNode());
                                        AnchorPane.setTopAnchor(win.getNode(), 280.0);
                                        AnchorPane.setLeftAnchor(win.getNode(), 500.0);
                                        win.play();

                                        Button b = new Button();
                                        b.setText("Back to Menu");
                                        b.setLayoutX(200);
                                        b.setLayoutY(50);
                                        b.setPrefWidth(200);
                                        b.setPrefHeight(50);
                                        b.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#a8a8a8;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        //������뿪��ťʱ�Ƴ���ӰЧ��
                                        b.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
//                                                        "-fx-border-style:dashed;"+      //���ñ߿���ʽ
//                                                        "-fx-border-width:5;"+           //���ñ߿���
//                                                        "-fx-border-insets:-5"           //���ñ߿����ֵ
                                                        + "-fx-font-size: 20"
                                        );
                                        AnchorPane.setTopAnchor(b, 400.);
                                        AnchorPane.setLeftAnchor(b, 530.);
                                        pane.getChildren().add(b);
                                        b.setOnMouseClicked(finish -> {
                                            try {
                                                Controller.backToMenu();
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                        });
                                    }
                                    if (line == 6 && !gameIsOver) {
                                        System.out.println("you lose");
                                        Rectangle recB = new Rectangle();
                                        recB.setFill(Color.BLACK);
                                        recB.setWidth(1280);
                                        recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                                        FadeTransition black = new FadeTransition();
                                        black.setNode(recB);
                                        black.setFromValue(0);
                                        black.setToValue(0.8);
                                        black.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(black.getNode());
                                        AnchorPane.setTopAnchor(black.getNode(), 0.);
                                        AnchorPane.setLeftAnchor(black.getNode(), 0.);
                                        black.play();

                                        FadeTransition win = new FadeTransition();
                                        Text text = new Text("LOSE!!");
                                        gameIsOver = true;
                                        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
                                        text.setTextAlignment(TextAlignment.JUSTIFY);
                                        text.setFill(Color.RED);
                                        win.setNode(text);
                                        win.setFromValue(0);
                                        win.setToValue(1);
                                        win.setDuration(Duration.seconds(1));
                                        pane.getChildren().add(win.getNode());
                                        AnchorPane.setTopAnchor(win.getNode(), 280.0);
                                        AnchorPane.setLeftAnchor(win.getNode(), 500.0);
                                        win.play();

                                        Button b = new Button();
                                        b.setText("Back to Menu");
                                        b.setLayoutX(200);
                                        b.setLayoutY(50);
                                        b.setPrefWidth(200);
                                        b.setPrefHeight(50);
                                        b.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#a8a8a8;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        //������뿪��ťʱ�Ƴ���ӰЧ��
                                        b.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                                        + "-fx-font-size: 20"
                                        ));
                                        b.setStyle(
                                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
//                                                        "-fx-border-style:dashed;"+      //���ñ߿���ʽ
//                                                        "-fx-border-width:5;"+           //���ñ߿���
//                                                        "-fx-border-insets:-5"           //���ñ߿����ֵ
                                                        + "-fx-font-size: 20"
                                        );
                                        AnchorPane.setTopAnchor(b, 400.);
                                        AnchorPane.setLeftAnchor(b, 530.);
                                        pane.getChildren().add(b);
                                        b.setOnMouseClicked(finish -> {
                                            try {
                                                Controller.backToMenu();
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                        });
                                    }
                                } else {
                                    System.out.println("Not in the list");

                                    Rectangle recB = new Rectangle();
                                    recB.setFill(Color.BLACK);
                                    recB.setWidth(1280);
                                    recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                                    FadeTransition black = new FadeTransition();
                                    black.setNode(recB);
                                    black.setFromValue(0);
                                    black.setToValue(0.2);
                                    black.setCycleCount(2);
                                    black.setAutoReverse(true);
                                    black.setDuration(Duration.seconds(1));


                                    pane.getChildren().add(black.getNode());
                                    AnchorPane.setTopAnchor(black.getNode(), 0.);
                                    AnchorPane.setLeftAnchor(black.getNode(), 0.);
                                    black.play();
                                    black.setOnFinished(finish-> pane.getChildren().remove(black.getNode()));

                                    FadeTransition win = new FadeTransition();
                                    Text text = new Text("Not in Word List!!");
                                    text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 80));
                                    text.setTextAlignment(TextAlignment.JUSTIFY);
                                    text.setFill(Color.YELLOW);
                                    win.setNode(text);
                                    win.setFromValue(0);
                                    win.setToValue(1);
                                    win.setDuration(Duration.seconds(1));
                                    win.setAutoReverse(true);
                                    win.setCycleCount(2);
                                    pane.getChildren().add(win.getNode());
                                    AnchorPane.setTopAnchor(win.getNode(), 300.0);
                                    AnchorPane.setLeftAnchor(win.getNode(), 350.0);
                                    win.play();
                                    win.setOnFinished(finish->{
                                        pane.getChildren().remove(win.getNode());
                                        System.out.println("YES");
                                    });
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
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        });
    }

    /**
     * �������˵�
     */
    public static void backMainMenu() {
        mainWindow.setScene(mainMenuScene);
        mainWindow.setTitle("WORDLE-EX");
        mainWindow.show();
    }

    public static void inputQ() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'q';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("Q");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����W
     *
     * @throws Exception �쳣
     */
    public static void inputW() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'w';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("W");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����E
     *
     * @throws Exception �쳣
     */
    public static void inputE() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'e';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("E");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }
    /**
     * ����R
     *
     * @throws Exception �쳣
     */
    public static void inputR() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'r';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("R");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����T
     *
     * @throws Exception �쳣
     */
    public static void inputT() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 't';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("T");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
            System.out.println(index);
            System.out.println(testword.letters.size());
            System.out.println(testword.WordContent);
        }
    }

    /**
     * ����Y
     *
     * @throws Exception �쳣
     */
    public static void inputY() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'y';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("Y");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����U
     *
     * @throws Exception �쳣
     */
    public static void inputU() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'u';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("U");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����I
     *
     * @throws Exception �쳣
     */
    public static void inputI() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'i';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("I");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����O
     *
     * @throws Exception �쳣
     */
    public static void inputO() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'o';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("O");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����P
     *
     * @throws Exception �쳣
     */
    public static void inputP() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'p';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("P");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����A
     *
     * @throws Exception �쳣
     */
    public static void inputA() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'a';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("A");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����S
     *
     * @throws Exception �쳣
     */
    public static void inputS() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 's';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("S");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����D
     *
     * @throws Exception �쳣
     */
    public static void inputD() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'd';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("D");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����F
     *
     * @throws Exception �쳣
     */
    public static void inputF() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'f';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("F");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����G
     *
     * @throws Exception �쳣
     */
    public static void inputG() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'g';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("G");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����H
     *
     * @throws Exception �쳣
     */
    public static void inputH() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'h';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("H");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����J
     *
     * @throws Exception �쳣
     */
    public static void inputJ() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'j';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("J");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����K
     *
     * @throws Exception �쳣
     */
    public static void inputK() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'k';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("K");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����L
     *
     * @throws Exception �쳣
     */
    public static void inputL() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'l';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("L");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����Z
     *
     * @throws Exception �쳣
     */
    public static void inputZ() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'z';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("Z");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����X
     *
     * @throws Exception �쳣
     */
    public static void inputX() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'x';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("X");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����C
     *
     * @throws Exception �쳣
     */
    public static void inputC() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'c';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("C");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����V
     *
     * @throws Exception �쳣
     */
    public static void inputV() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'v';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("V");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����B
     *
     * @throws Exception �쳣
     */
    public static void inputB() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'b';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("B");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����N
     *
     * @throws Exception �쳣
     */
    public static void inputN() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'n';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("N");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * ����M
     *
     * @throws Exception �쳣
     */
    public static void inputM() throws Exception {
        if (index < 5) {
            char toAddLetter;
            toAddLetter = 'm';
            testword.AddLetter(toAddLetter);
            aniLetters[index] = new AniLetter("M");
            pane.getChildren().add(aniLetters[index].ft.getNode());
            AnchorPane.setLeftAnchor(aniLetters[index].ft.getNode(), 500.0 + index * 60.0);
            AnchorPane.setTopAnchor(aniLetters[index].ft.getNode(), 120.0 + line * 60.);
            aniLetters[index].ft.play();
            index += 1;
        }
    }

    /**
     * �����˸�

     */
    public static void backSpace() {
        if (index >= 1) {
            testword.RemoveLetter();
            pane.getChildren().remove(aniLetters[index - 1].ft.getNode());
            index -= 1;
        }
    }

    /**
     * normalģʽ�س�����

     */
    public static void mainEnter() {
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
                            Controller.changeButtonColor(testword.letters.get(i).letterContent, 3);
                        }
                        if (testword.letters.get(i).letterColor == LetterColor.Yellow) {
                            aniLetters[i].text.setFill(Color.YELLOW);
                            Controller.changeButtonColor(testword.letters.get(i).letterContent, 2);
                        }
                        if (testword.letters.get(i).letterColor == LetterColor.Grey) {
                            aniLetters[i].text.setFill(Color.BLACK);
                            Controller.changeButtonColor(testword.letters.get(i).letterContent, 1);
                        }

                    }
                    status = testword.getState();
                    if (status == 0) {
                        System.out.println("you win");

                        Rectangle recB = new Rectangle();
                        recB.setFill(Color.BLACK);
                        recB.setWidth(1280);
                        recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                        FadeTransition black = new FadeTransition();
                        black.setNode(recB);
                        black.setFromValue(0);
                        black.setToValue(0.8);
                        black.setDuration(Duration.seconds(1));
                        pane.getChildren().add(black.getNode());
                        AnchorPane.setTopAnchor(black.getNode(), 0.);
                        AnchorPane.setLeftAnchor(black.getNode(), 0.);
                        black.play();

                        FadeTransition win = new FadeTransition();
                        Text text = new Text("WIN!!");
                        gameIsOver = true;
                        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
                        text.setTextAlignment(TextAlignment.JUSTIFY);
                        text.setFill(Color.GREEN);
                        win.setNode(text);
                        win.setFromValue(0);
                        win.setToValue(1);
                        win.setDuration(Duration.seconds(1));
                        pane.getChildren().add(win.getNode());
                        AnchorPane.setTopAnchor(win.getNode(), 280.0);
                        AnchorPane.setLeftAnchor(win.getNode(), 500.0);
                        win.play();

                        Button b = new Button();
                        b.setText("Back to Menu");
                        b.setLayoutX(200);
                        b.setLayoutY(50);
                        b.setPrefWidth(200);
                        b.setPrefHeight(50);
                        //�������밴ťʱ�����Ӱ��Ч
                        b.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> b.setStyle(
                                "-fx-background-color:#a8a8a8;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        ));
                        //������뿪��ťʱ�Ƴ���ӰЧ��
                        b.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> b.setStyle(
                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        ));
                        b.setStyle(
                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        );
                        AnchorPane.setTopAnchor(b, 400.);
                        AnchorPane.setLeftAnchor(b, 530.);
                        pane.getChildren().add(b);
                        b.setOnMouseClicked(finish -> {
                            try {
                                Controller.backToMenu();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                    if (line == 6 && !gameIsOver) {
                        System.out.println("you lose");

                        Rectangle recB = new Rectangle();
                        recB.setFill(Color.BLACK);
                        recB.setWidth(1280);
                        recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                        FadeTransition black = new FadeTransition();
                        black.setNode(recB);
                        black.setFromValue(0);
                        black.setToValue(0.8);
                        black.setDuration(Duration.seconds(1));
                        pane.getChildren().add(black.getNode());
                        AnchorPane.setTopAnchor(black.getNode(), 0.);
                        AnchorPane.setLeftAnchor(black.getNode(), 0.);
                        black.play();

                        FadeTransition win = new FadeTransition();
                        Text text = new Text("LOSE!!");
                        gameIsOver = true;
                        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
                        text.setTextAlignment(TextAlignment.JUSTIFY);
                        text.setFill(Color.RED);
                        win.setNode(text);
                        win.setFromValue(0);
                        win.setToValue(1);
                        win.setDuration(Duration.seconds(1));
                        pane.getChildren().add(win.getNode());
                        AnchorPane.setTopAnchor(win.getNode(), 280.0);
                        AnchorPane.setLeftAnchor(win.getNode(), 500.0);
                        win.play();

                        Button b = new Button();
                        b.setText("Back to Menu");
                        b.setLayoutX(200);
                        b.setLayoutY(50);
                        b.setPrefWidth(200);
                        b.setPrefHeight(50);
                        //�������밴ťʱ�����Ӱ��Ч
                        b.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> b.setStyle(
                                "-fx-background-color:#a8a8a8;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        ));
                        //������뿪��ťʱ�Ƴ���ӰЧ��
                        b.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> b.setStyle(
                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        ));
                        b.setStyle(
                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        );
                        AnchorPane.setTopAnchor(b, 400.);
                        AnchorPane.setLeftAnchor(b, 530.);
                        pane.getChildren().add(b);
                        b.setOnMouseClicked(finish -> {
                            try {
                                Controller.backToMenu();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                    for (int i = 0; i < 5; i++) {
                        testword.RemoveLetter();
                    }

                } else {
                    System.out.println("Not in the list");

                    Rectangle recB = new Rectangle();
                    recB.setFill(Color.BLACK);
                    recB.setWidth(1280);
                    recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                    FadeTransition black = new FadeTransition();
                    black.setNode(recB);
                    black.setFromValue(0);
                    black.setToValue(0.2);
                    black.setCycleCount(2);
                    black.setAutoReverse(true);
                    black.setDuration(Duration.seconds(1));


                    pane.getChildren().add(black.getNode());
                    AnchorPane.setTopAnchor(black.getNode(), 0.);
                    AnchorPane.setLeftAnchor(black.getNode(), 0.);
                    black.play();
                    black.setOnFinished(finish-> pane.getChildren().remove(black.getNode()));

                    FadeTransition win = new FadeTransition();
                    Text text = new Text("Not in Word List!!");
                    text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 80));
                    text.setTextAlignment(TextAlignment.JUSTIFY);
                    text.setFill(Color.YELLOW);
                    win.setNode(text);
                    win.setFromValue(0);
                    win.setToValue(1);
                    win.setDuration(Duration.seconds(1));
                    win.setAutoReverse(true);
                    win.setCycleCount(2);
                    pane.getChildren().add(win.getNode());
                    AnchorPane.setTopAnchor(win.getNode(), 300.0);
                    AnchorPane.setLeftAnchor(win.getNode(), 350.0);
                    win.play();
                    win.setOnFinished(finish->{
                        pane.getChildren().remove(win.getNode());
                        System.out.println("YES");
                    });
                }

            } catch (Exception e) {
                //throw new RuntimeException(e);
                System.out.println("Not in the list");
                for (int i = 0; i < 5; i++) {
                    testword.RemoveLetter();
                }
            }
        } else {
            System.out.println(testword.WordContent);
            System.out.println(testword.letters.size());
            System.out.println("not enough letter!");
        }
    }

    /**
     * advanceģʽ�س�����
     */
    public static void advanceEnter() {
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
                            advanceController.changeButtonColor(testword.letters.get(i).letterContent, 3);
                        }
                        if (testword.letters.get(i).letterColor == LetterColor.Yellow) {
                            aniLetters[i].text.setFill(Color.YELLOW);
                            advanceController.changeButtonColor(testword.letters.get(i).letterContent, 2);
                        }
                        if (testword.letters.get(i).letterColor == LetterColor.Grey) {
                            aniLetters[i].text.setFill(Color.BLACK);
                            System.out.println("changecolorbegin");
                            advanceController.changeButtonColor(testword.letters.get(i).letterContent, 1);
                            System.out.println("changecolorend");
                        }
                    }
                    status = testword.getState();

                    WordList.PossibleWord = GuessAlgorithm.updatePossibleWord(WordList.PossibleWord, testword.getState(), testword.WordContent.toString());
                    GuessAlgorithm.possibilities = WordList.PossibleWord.size();
                    double newE = GuessAlgorithm.calENow(WordList.PossibleWord);
                    double info = GuessAlgorithm.eNow - newE;

                    AniString infoString = new AniString(df2.format(info) + "bits", Color.WHITE);
                    pane.getChildren().add(infoString.ft.getNode());
                    AnchorPane.setLeftAnchor(infoString.ft.getNode(), 800.0);
                    AnchorPane.setTopAnchor(infoString.ft.getNode(), 125.0 + leftLine * 60.0);
                    infoString.ft.play();

                    GuessAlgorithm.eNow = newE;
                    leftLine++;
                    aniStrings.add(new AniString("Possibilities:", Color.WHITE));
                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0);
                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                    aniStrings.get(aniStrings.size() - 1).ft.play();

                    aniStrings.add(new AniString("" + GuessAlgorithm.possibilities, Color.WHITE));
                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0 + aniStrings.size() * 75.0);
                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                    aniStrings.get(aniStrings.size() - 1).ft.play();

                    aniStrings.add(new AniString("/ E:", Color.SKYBLUE));
                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 150.0 + aniStrings.size() * 75.0);
                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                    aniStrings.get(aniStrings.size() - 1).ft.play();

                    // ����С�������λ
                    DecimalFormat df = new DecimalFormat("#.00");
                    aniStrings.add(new AniString("" + df.format(GuessAlgorithm.eNow), Color.SKYBLUE));
                    pane.getChildren().add(aniStrings.get(aniStrings.size() - 1).ft.getNode());
                    AnchorPane.setLeftAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 120 + aniStrings.size() * 75.0);
                    AnchorPane.setTopAnchor(aniStrings.get(aniStrings.size() - 1).ft.getNode(), 125.0 + leftLine * 60.0);
                    aniStrings.get(aniStrings.size() - 1).ft.play();

                    aniStrings.clear();

                    GuessAlgorithm.getWordScore(WordList.LegalWord, WordList.PossibleWord);
                    for (int i = 0; i < 5 && i < GuessAlgorithm.wsList.size(); i++) {
                        System.out.println(GuessAlgorithm.wsList.get(i).word + " " + GuessAlgorithm.wsList.get(i).entropy + " " + GuessAlgorithm.wsList.get(i).possible + " " + GuessAlgorithm.wsList.get(i).score);
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

                    for (int i = 0; i < 5 && i < GuessAlgorithm.wsList.size(); i++) {
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

                    if (status == 0) {
                        System.out.println("you win");

                        Rectangle recB = new Rectangle();
                        recB.setFill(Color.BLACK);
                        recB.setWidth(1280);
                        recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                        FadeTransition black = new FadeTransition();
                        black.setNode(recB);
                        black.setFromValue(0);
                        black.setToValue(0.8);
                        black.setDuration(Duration.seconds(1));
                        pane.getChildren().add(black.getNode());
                        AnchorPane.setTopAnchor(black.getNode(), 0.);
                        AnchorPane.setLeftAnchor(black.getNode(), 0.);
                        black.play();

                        FadeTransition win = new FadeTransition();
                        Text text = new Text("WIN!!");
                        gameIsOver = true;
                        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
                        text.setTextAlignment(TextAlignment.JUSTIFY);
                        text.setFill(Color.GREEN);
                        win.setNode(text);
                        win.setFromValue(0);
                        win.setToValue(1);
                        win.setDuration(Duration.seconds(1));
                        pane.getChildren().add(win.getNode());
                        AnchorPane.setTopAnchor(win.getNode(), 280.0);
                        AnchorPane.setLeftAnchor(win.getNode(), 500.0);
                        win.play();

                        Button b = new Button();
                        b.setText("Back to Menu");
                        b.setLayoutX(200);
                        b.setLayoutY(50);
                        b.setPrefWidth(200);
                        b.setPrefHeight(50);
                        //�������밴ťʱ�����Ӱ��Ч
                        b.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> b.setStyle(
                                "-fx-background-color:#a8a8a8;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        ));
                        //������뿪��ťʱ�Ƴ���ӰЧ��
                        b.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> b.setStyle(
                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        ));
                        b.setStyle(
                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        );
                        AnchorPane.setTopAnchor(b, 400.);
                        AnchorPane.setLeftAnchor(b, 530.);
                        pane.getChildren().add(b);
                        b.setOnMouseClicked(finish -> {
                            try {
                                advanceController.backToMenu();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                    if (line == 6 && !gameIsOver) {
                        System.out.println("you lose");

                        Rectangle recB = new Rectangle();
                        recB.setFill(Color.BLACK);
                        recB.setWidth(1280);
                        recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                        FadeTransition black = new FadeTransition();
                        black.setNode(recB);
                        black.setFromValue(0);
                        black.setToValue(0.8);
                        black.setDuration(Duration.seconds(1));
                        pane.getChildren().add(black.getNode());
                        AnchorPane.setTopAnchor(black.getNode(), 0.);
                        AnchorPane.setLeftAnchor(black.getNode(), 0.);
                        black.play();

                        FadeTransition win = new FadeTransition();
                        Text text = new Text("LOSE!!");
                        gameIsOver = true;
                        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
                        text.setTextAlignment(TextAlignment.JUSTIFY);
                        text.setFill(Color.RED);
                        win.setNode(text);
                        win.setFromValue(0);
                        win.setToValue(1);
                        win.setDuration(Duration.seconds(1));
                        pane.getChildren().add(win.getNode());
                        AnchorPane.setTopAnchor(win.getNode(), 280.0);
                        AnchorPane.setLeftAnchor(win.getNode(), 500.0);
                        win.play();

                        Button b = new Button();
                        b.setText("Back to Menu");
                        b.setLayoutX(200);
                        b.setLayoutY(50);
                        b.setPrefWidth(200);
                        b.setPrefHeight(50);
                        //�������밴ťʱ�����Ӱ��Ч
                        b.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> b.setStyle(
                                "-fx-background-color:#a8a8a8;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        ));
                        //������뿪��ťʱ�Ƴ���ӰЧ��
                        b.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> b.setStyle(
                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        ));
                        b.setStyle(
                                "-fx-background-color:#7a7a7a;" +         //���ñ�����ɫ
                                        "-fx-background-radius:5;" +     //���ñ���Բ��
                                        "-fx-text-fill:#ffffff;" +        //����������ɫ
                                        "-fx-border-radius:5;" +         //���ñ߿�Բ��
                                        "-fx-border-color:#838383;"     //���ñ߿���ɫ
                                        + "-fx-font-size: 20"
                        );
                        AnchorPane.setTopAnchor(b, 400.);
                        AnchorPane.setLeftAnchor(b, 530.);
                        pane.getChildren().add(b);
                        b.setOnMouseClicked(finish -> {
                            try {
                                Controller.backToMenu();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }

                } else {
                    System.out.println("Not in the list");


                    Rectangle recB = new Rectangle();
                    recB.setFill(Color.BLACK);
                    recB.setWidth(1280);
                    recB.setHeight(800);
//                                        pane.getChildren().add(recB);
                    FadeTransition black = new FadeTransition();
                    black.setNode(recB);
                    black.setFromValue(0);
                    black.setToValue(0.2);
                    black.setCycleCount(2);
                    black.setAutoReverse(true);
                    black.setDuration(Duration.seconds(1));


                    pane.getChildren().add(black.getNode());
                    AnchorPane.setTopAnchor(black.getNode(), 0.);
                    AnchorPane.setLeftAnchor(black.getNode(), 0.);
                    black.play();
                    black.setOnFinished(finish-> pane.getChildren().remove(black.getNode()));

                    FadeTransition win = new FadeTransition();
                    Text text = new Text("Not in Word List!!");
                    text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 80));
                    text.setTextAlignment(TextAlignment.JUSTIFY);
                    text.setFill(Color.YELLOW);
                    win.setNode(text);
                    win.setFromValue(0);
                    win.setToValue(1);
                    win.setDuration(Duration.seconds(1));
                    win.setAutoReverse(true);
                    win.setCycleCount(2);
                    pane.getChildren().add(win.getNode());
                    AnchorPane.setTopAnchor(win.getNode(), 300.0);
                    AnchorPane.setLeftAnchor(win.getNode(), 350.0);
                    win.play();
                    win.setOnFinished(finish->{
                        pane.getChildren().remove(win.getNode());
                        System.out.println("YES");
                    });
                }

            } catch (Exception e) {
                //throw new RuntimeException(e);
                System.out.println(e);
                for (int i = 0; i < 5; i++) {
                    testword.RemoveLetter();
                }
            }
        } else {
            System.out.println("not enough letter!");
        }
    }
}
