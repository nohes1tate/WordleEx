import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MenuScene {

    /**
     * �������밴ť����ı������ʽ�ķ�����
     */
    public void mouseOnButton(){
        Main.getMainMenuScene().setCursor(Cursor.HAND);
    }
    /**
     * ������뿪��ť����ı������ʽ�ķ�����
     */
    public void mouseLeaveButton(){
        Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
    }

    /**
     * ��ʼ������ť
     *
     * @throws Exception �쳣
     */
    public void startNormalButton() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/mainScene.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.startNormalMode();
    }

    public void backToMenu() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/menuScene.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.backMainMenu();
    }
}
