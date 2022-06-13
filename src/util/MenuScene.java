import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuScene {

    @FXML
    private static Button ButtonQ;

    @FXML
    private Button ButtonW;

    @FXML
    private Button ButtonE;

    @FXML
    private Button ButtonR;

    @FXML
    private Button ButtonT;

    @FXML
    private Button ButtonY;

    @FXML
    private Button ButtonU;

    @FXML
    private Button ButtonI;

    @FXML
    private Button ButtonO;

    @FXML
    private Button ButtonP;

    @FXML
    private Button ButtonA;

    @FXML
    private Button ButtonS;

    @FXML
    private Button ButtonD;

    @FXML
    private Button ButtonF;

    @FXML
    private Button ButtonG;

    @FXML
    private Button ButtonH;

    @FXML
    private Button ButtonJ;

    @FXML
    private Button ButtonK;

    @FXML
    private Button ButtonL;

    @FXML
    private Button ButtonZ;

    @FXML
    private Button ButtonX;

    @FXML
    private Button ButtonC;

    @FXML
    private Button ButtonV;

    @FXML
    private Button ButtonB;

    @FXML
    private Button ButtonN;

    @FXML
    private Button ButtonM;

    @FXML
    private Button ButtonENTER;

    @FXML
    private Button ButtonBackspace;

    /**
     * 当鼠标进入按钮区域改变鼠标样式的方法。
     */
    public void mouseOnButton(){
       // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
    }
    /**
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
      }

      public void testMethod(){
        System.out.println("testMethod");
          }

    /**
     * 开始普通模式的方法。
     *
     * @throws Exception 异常
     */
    public void startNormalButton() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/mainScene.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.startNormalMode();
    }

    /**
     * 开始进阶模式的方法。
     *
     * @throws Exception 异常
     */
    public void startAdvanceButton() throws Exception {
        Parent advanceLayout = FXMLLoader.load(Main.class.getResource("/resources/advanceScene.fxml"));
        Main.setMainMenuScene(new Scene(advanceLayout));
        Main.startAdvanceMode();
    }

    public void startAIShowButton() throws Exception {
        Parent aiShowLayout = FXMLLoader.load(Main.class.getResource("/resources/aiShowScene.fxml"));
        Main.setMainMenuScene(new Scene(aiShowLayout));
        Main.startAIShowMode();
    }

    /**
     * 回到菜单
     *
     * @throws Exception 异常
     */
    public void backToMenu() throws Exception {
        GuessAlgorithm.isFirst= true;
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/menuScene.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.backMainMenu();
    }



    public static void changeButtonQColor(int color) throws Exception{
        if(color==1)
        {
            BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(5),new Insets(10));
            Background background = new Background(background_fill);
            ButtonQ.setBackground(background);
            System.out.println("changeButtonQColor");
        }

    }
}
