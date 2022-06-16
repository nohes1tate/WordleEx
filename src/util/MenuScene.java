import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MenuScene {

    @FXML
    private ImageView backImg;

    @FXML
    private Button ButtonQ;

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

    @FXML
    private Text normalMode;

    @FXML
    private Text advanceMode;

    @FXML
    private Text AIShow;

    @FXML
    private Text quit;

    @FXML
    private ImageView helpImg;

    @FXML
    private Button helpButton;

    /**
     * 当鼠标进入按钮区域改变鼠标样式的方法。
     */
    public void mouseOnNormalButton(){
       // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        normalMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        normalMode.setX(-20);
    }
    /**
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveNormalButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        normalMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        normalMode.setX(5);
      }

    public void mouseOnAdvanceButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        advanceMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        advanceMode.setX(-20);
    }
    /**
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveAdvanceButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        advanceMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        advanceMode.setX(5);
    }
    public void mouseOnAIButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        AIShow.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        AIShow.setX(-20);
    }
    /**
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveAIButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        AIShow.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        AIShow.setX(5);
    }
    public void mouseOnQuitButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        quit.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        quit.setX(-10);
    }
    /**
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveQuitButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        quit.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        quit.setX(5);
    }

    public void mouseOnBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        backImg.setImage(new Image("arrow1.png"));
    }
    public void mouseLeaveBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        backImg.setImage(new Image("arrow.png"));
    }
    public void mouseOnHelpImg(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        helpImg.setImage(new Image("rule1.png"));
    }
    public void mouseLeaveHelpImg(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        helpImg.setImage(new Image("rule.png"));
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

    public void toRule() throws Exception{
        Parent ruleLayout = FXMLLoader.load(Main.class.getResource("/resources/basicRule.fxml"));
        Main.setMainMenuScene(new Scene(ruleLayout));
        Main.toRuleView();
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

    public void quitButton() {
        System.exit(0);
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

    public void changeButtonColor(char key,int color) {
        AdvanceScene.changeButtonColor(key, color, ButtonQ, ButtonW, ButtonE, ButtonR, ButtonT, ButtonY, ButtonU, ButtonI, ButtonO, ButtonP, ButtonA, ButtonS, ButtonD, ButtonF, ButtonG, ButtonH, ButtonJ, ButtonK, ButtonL, ButtonZ, ButtonX, ButtonC, ButtonV, ButtonB, ButtonN, ButtonM);
    }

    public void inputQ() throws Exception{
        Main.inputQ();
    }
    public void inputW() throws Exception{
        Main.inputW();
    }
    public void inputE() throws Exception{
        Main.inputE();
    }
    public void inputR() throws Exception{
        Main.inputR();
    }
    public void inputT() throws Exception{
        Main.inputT();
    }
    public void inputY() throws Exception{
        Main.inputY();
    }
    public void inputU() throws Exception{
        Main.inputU();
    }
    public void inputI() throws Exception{
        Main.inputI();
    }
    public void inputO() throws Exception{
        Main.inputO();
    }
    public void inputP() throws Exception{
        Main.inputP();
    }
    public void inputA() throws Exception{
        Main.inputA();
    }
    public void inputS() throws Exception{
        Main.inputS();
    }
    public void inputD() throws Exception{
        Main.inputD();
    }
    public void inputF() throws Exception{
        Main.inputF();
    }
    public void inputG() throws Exception{
        Main.inputG();
    }
    public void inputH() throws Exception{
        Main.inputH();
    }
    public void inputJ() throws Exception{
        Main.inputJ();
    }
    public void inputK() throws Exception{
        Main.inputK();
    }
    public void inputL() throws Exception{
        Main.inputL();
    }
    public void inputZ() throws Exception{
        Main.inputZ();
    }
    public void inputX() throws Exception{
        Main.inputX();
    }
    public void inputC() throws Exception{
        Main.inputC();
    }
    public void inputV() throws Exception{
        Main.inputV();
    }
    public void inputB() throws Exception{
        Main.inputB();
    }
    public void inputN() throws Exception{
        Main.inputN();
    }
    public void inputM() throws Exception{
        Main.inputM();
    }
    public void backSpace() {
        Main.backSpace();
    }
    public void mainEnter() {
        Main.mainEnter();
    }
}
