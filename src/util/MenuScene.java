import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MenuScene {

    @FXML
    public Button button;

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
}
