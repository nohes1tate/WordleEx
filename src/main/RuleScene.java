import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RuleScene {

    @FXML
    private ImageView backImg;

    @FXML
    private ImageView leftArrow;

    @FXML
    private ImageView rightArrow;

    public void backToMenu() throws Exception {
        GuessAlgorithm.isFirst= true;
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/menuScene.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.backMainMenu();
    }
    public void toBasicRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/basicRule.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toRuleView();
    }
    public void toNormalRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/NormalMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toNormalRule();
    }
    public void toAdvanceRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/AdvanceMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toAdvanceRule();
    }
    public void toAIRule() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/AIMode.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.toAIRule();
    }
    public void mouseOnBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        backImg.setImage(new Image("arrow1.png"));
    }
    public void mouseLeaveBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        backImg.setImage(new Image("arrow.png"));
    }

    public void mouseOnLeftArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        leftArrow.setImage(new Image("arrowL1.png"));
    }
    public void mouseLeaveLeftArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        leftArrow.setImage(new Image("arrowL.png"));
    }
    public void mouseOnRightArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        rightArrow.setImage(new Image("arrowR1.png"));
    }
    public void mouseLeaveRightArrow() {
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        rightArrow.setImage(new Image("arrowR.png"));
    }
}
