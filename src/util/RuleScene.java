import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * ���򳡾�
 *
 * @author 86153
 * @date 2022/06/16
 */
public class RuleScene {

    /**
     * img����
     */
    @FXML
    private ImageView backImg;

    /**
     * ���ͷ��
     */
    @FXML
    private ImageView leftArrow;

    /**
     * �Ҽ�ͷ
     */
    @FXML
    private ImageView rightArrow;

    /**
     * �ص��˵�
     *
     * @throws Exception �쳣
     */
    public void backToMenu() throws Exception {
        GuessAlgorithm.isFirst= true;
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/menuScene.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.backMainMenu();
    }

    /**
     * ��������
     *
     * @throws Exception �쳣
     */
    public void toBasicRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/basicRule.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toRuleView();
    }

    /**
     * ��������
     *
     * @throws Exception �쳣
     */
    public void toNormalRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/NormalMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toNormalRule();
    }

    /**
     * �ƽ�����
     *
     * @throws Exception �쳣
     */
    public void toAdvanceRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/AdvanceMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toAdvanceRule();
    }

    /**
     * ��airule
     *
     * @throws Exception �쳣
     */
    public void toAIRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/AIMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toAIRule();
    }

    /**
     * ����ں��˰�ť
     */
    public void mouseOnBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        backImg.setImage(new Image("arrow1.png"));
    }

    /**
     * ����뿪���˰�ť
     */
    public void mouseLeaveBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        backImg.setImage(new Image("arrow.png"));
    }

    /**
     * ������ͷ
     */
    public void mouseOnLeftArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        leftArrow.setImage(new Image("arrowL1.png"));
    }

    /**
     * ����뿪���ͷ��
     */
    public void mouseLeaveLeftArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        leftArrow.setImage(new Image("arrowL.png"));
    }

    /**
     * ������Ҽ�ͷ
     */
    public void mouseOnRightArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        rightArrow.setImage(new Image("arrowR1.png"));
    }

    /**
     * ����뿪�Ҽ�ͷ
     */
    public void mouseLeaveRightArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        rightArrow.setImage(new Image("arrowR.png"));
    }
}
