import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 规则场景
 *
 * @author 86153
 * @date 2022/06/16
 */
public class RuleScene {

    /**
     * img回来
     */
    @FXML
    private ImageView backImg;

    /**
     * 左箭头键
     */
    @FXML
    private ImageView leftArrow;

    /**
     * 右箭头
     */
    @FXML
    private ImageView rightArrow;

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

    /**
     * 基本规则
     *
     * @throws Exception 异常
     */
    public void toBasicRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/basicRule.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toRuleView();
    }

    /**
     * 正常规则
     *
     * @throws Exception 异常
     */
    public void toNormalRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/NormalMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toNormalRule();
    }

    /**
     * 推进规则
     *
     * @throws Exception 异常
     */
    public void toAdvanceRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/AdvanceMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toAdvanceRule();
    }

    /**
     * 对airule
     *
     * @throws Exception 异常
     */
    public void toAIRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/AIMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toAIRule();
    }

    /**
     * 鼠标在后退按钮
     */
    public void mouseOnBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        backImg.setImage(new Image("arrow1.png"));
    }

    /**
     * 鼠标离开后退按钮
     */
    public void mouseLeaveBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        backImg.setImage(new Image("arrow.png"));
    }

    /**
     * 鼠标左箭头
     */
    public void mouseOnLeftArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        leftArrow.setImage(new Image("arrowL1.png"));
    }

    /**
     * 鼠标离开左箭头键
     */
    public void mouseLeaveLeftArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        leftArrow.setImage(new Image("arrowL.png"));
    }

    /**
     * 鼠标在右箭头
     */
    public void mouseOnRightArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        rightArrow.setImage(new Image("arrowR1.png"));
    }

    /**
     * 鼠标离开右箭头
     */
    public void mouseLeaveRightArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        rightArrow.setImage(new Image("arrowR.png"));
    }
}
