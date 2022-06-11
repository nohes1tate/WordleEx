import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MenuScene {

    /**
     * 当鼠标进入按钮区域改变鼠标样式的方法。
     */
    public void mouseOnButton(){
        Main.getMainMenuScene().setCursor(Cursor.HAND);
    }
    /**
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveButton(){
        Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
    }

    public void test() throws Exception {
        System.out.println("test");
    }

    public void startNormalButton() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/mainScene.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.startNormalMode();
    }
}
