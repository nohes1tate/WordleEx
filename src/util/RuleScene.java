import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 规则场景
 */
public class RuleScene {

    /**
     * 回到主菜单的图片
     */
    @FXML
    private ImageView backImg;

    /**
     * 左箭头键
     */
    @FXML
    private ImageView leftArrow;

    /**
     * 右箭头键
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
     * 进入基本规则介绍页面
     *
     * @throws Exception 异常
     */
    public void toBasicRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/basicRule.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toRuleView();
    }

    /**
     * 进入正常规则介绍页面
     *
     * @throws Exception 异常
     */
    public void toNormalRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/NormalMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toNormalRule();
    }

    /**
     * 进入高阶模式规则页面
     *
     * @throws Exception 异常
     */
    public void toAdvanceRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/AdvanceMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toAdvanceRule();
    }

    /**
     * 进入AI模式规则页面
     *
     * @throws Exception 异常
     */
    public void toAIRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/AIMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toAIRule();
    }

    /**
     * 鼠标进入回到菜单按钮时改变样式
     */
    public void mouseOnBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        backImg.setImage(new Image("arrow1.png"));
    }

    /**
     * 鼠标离开回到菜单按钮时改变样式
     */
    public void mouseLeaveBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        backImg.setImage(new Image("arrow.png"));
    }

    /**
     * 鼠标进入左箭头键时改变样式
     */
    public void mouseOnLeftArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        leftArrow.setImage(new Image("arrowL1.png"));
    }

    /**
     * 鼠标离开左箭头键时改变样式
     */
    public void mouseLeaveLeftArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        leftArrow.setImage(new Image("arrowL.png"));
    }

    /**
     * 鼠标进入右箭头键时改变样式
     */
    public void mouseOnRightArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        rightArrow.setImage(new Image("arrowR1.png"));
    }

    /**
     * 鼠标离开右箭头键时改变样式
     */
    public void mouseLeaveRightArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        rightArrow.setImage(new Image("arrowR.png"));
    }
}
