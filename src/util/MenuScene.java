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

/**
 * 场景控件方法。
 */
public class MenuScene {

    /**
     * 返回图标
     */
    @FXML
    private ImageView backImg;

    /**
     * 屏幕键盘按钮Q
     */
    @FXML
    private Button ButtonQ;

    /**
     * 屏幕键盘按钮W
     */
    @FXML
    private Button ButtonW;

    /**
     * 屏幕键盘按钮E
     */
    @FXML
    private Button ButtonE;

    /**
     * 屏幕键盘按钮R
     */
    @FXML
    private Button ButtonR;

    /**
     * 屏幕键盘按钮T
     */
    @FXML
    private Button ButtonT;

    /**
     * 屏幕键盘按钮Y
     */
    @FXML
    private Button ButtonY;

    /**
     * 屏幕键盘按钮U
     */
    @FXML
    private Button ButtonU;

    /**
     * 屏幕键盘按钮I
     */
    @FXML
    private Button ButtonI;

    /**
     * 屏幕键盘按钮O
     */
    @FXML
    private Button ButtonO;

    /**
     * 屏幕键盘按钮P
     */
    @FXML
    private Button ButtonP;

    /**
     * 屏幕键盘按钮IA
     */
    @FXML
    private Button ButtonA;

    /**
     * 屏幕键盘按钮S
     */
    @FXML
    private Button ButtonS;

    /**
     * 屏幕键盘按钮D
     */
    @FXML
    private Button ButtonD;

    /**
     * 屏幕键盘按钮F
     */
    @FXML
    private Button ButtonF;

    /**
     * 屏幕键盘按钮G
     */
    @FXML
    private Button ButtonG;

    /**
     * 屏幕键盘按钮H
     */
    @FXML
    private Button ButtonH;

    /**
     * 屏幕键盘按钮J
     */
    @FXML
    private Button ButtonJ;

    /**
     * 屏幕键盘按钮K
     */
    @FXML
    private Button ButtonK;

    /**
     * 屏幕键盘按钮L
     */
    @FXML
    private Button ButtonL;

    /**
     * 屏幕键盘按钮Z
     */
    @FXML
    private Button ButtonZ;

    /**
     * 屏幕键盘按钮X
     */
    @FXML
    private Button ButtonX;

    /**
     * 屏幕键盘按钮C
     */
    @FXML
    private Button ButtonC;

    /**
     * 屏幕键盘按钮V
     */
    @FXML
    private Button ButtonV;

    /**
     * 屏幕键盘按钮B
     */
    @FXML
    private Button ButtonB;

    /**
     * 屏幕键盘按钮N
     */
    @FXML
    private Button ButtonN;

    /**
     * 屏幕键盘按钮M
     */
    @FXML
    private Button ButtonM;

    /**
     * 屏幕键盘回车按钮
     */
    @FXML
    private Button ButtonENTER;

    /**
     * 屏幕键盘退格按钮
     */
    @FXML
    private Button ButtonBackspace;

    /**
     * 正常模式文本
     */
    @FXML
    private Text normalMode;

    /**
     * 进阶模式文本
     */
    @FXML
    private Text advanceMode;

    /**
     * AI演示文本
     */
    @FXML
    private Text AIShow;

    /**
     * 退出文本
     */
    @FXML
    private Text quit;

    /**
     * 帮助图标
     */
    @FXML
    private ImageView helpImg;

    /**
     * 帮助按钮
     */
    @FXML
    private Button helpButton;

    /**
     * 鼠标在正常模式按钮上文本变更的方法。
     */
    public void mouseOnNormalButton(){
       // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        normalMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        normalMode.setX(-20);
    }

    /**
     * 鼠标离开正常模式按钮文本变更的方法。
     */
    public void mouseLeaveNormalButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        normalMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        normalMode.setX(5);
      }

    /**
     * 鼠标在进阶模式按钮上文本变更的方法。
     */
    public void mouseOnAdvanceButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        advanceMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        advanceMode.setX(-20);
    }

    /**
     * 鼠标离开进阶模式按钮文本变更的方法。
     */
    public void mouseLeaveAdvanceButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        advanceMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        advanceMode.setX(5);
    }

    /**
     * 鼠标在AI演示模式按钮上文本变更的方法。
     */
    public void mouseOnAIButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        AIShow.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        AIShow.setX(-20);
    }

    /**
     * 鼠标离开AI演示模式按钮文本变更的方法。
     */
    public void mouseLeaveAIButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        AIShow.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        AIShow.setX(5);
    }

    /**
     * 鼠标在退出按钮上文本变更的方法。
     */
    public void mouseOnQuitButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        quit.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        quit.setX(-10);
    }

    /**
     * 鼠标离开退出按钮文本变更的方法。
     */
    public void mouseLeaveQuitButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        quit.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        quit.setX(5);
    }

    /**
     * 鼠标在返回按钮图片变化的方法。
     */
    public void mouseOnBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        backImg.setImage(new Image("arrow1.png"));
    }

    /**
     * 鼠标离开返回按钮图片变化的方法。
     */
    public void mouseLeaveBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        backImg.setImage(new Image("arrow.png"));
    }

    /**
     * 鼠标在帮助图标上图片变化的方法。
     */
    public void mouseOnHelpImg(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        helpImg.setImage(new Image("rule1.png"));
    }

    /**
     * 鼠标离开帮助图标图片变化的方法。
     */
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

    /**
     * 进入规则说明的方法。
     *
     * @throws Exception 异常
     */
    public void toRule() throws Exception{
        Parent ruleLayout = FXMLLoader.load(Main.class.getResource("/resources/basicRule.fxml"));
        Main.setMainMenuScene(new Scene(ruleLayout));
        Main.toRuleView();
    }

    /**
     * 进入进阶模式的方法。
     *
     * @throws Exception 异常
     */
    public void startAdvanceButton() throws Exception {
        Parent advanceLayout = FXMLLoader.load(Main.class.getResource("/resources/advanceScene.fxml"));
        Main.setMainMenuScene(new Scene(advanceLayout));
        Main.startAdvanceMode();
    }

    /**
     * 进入AI演示模式的方法
     *
     * @throws Exception 异常
     */
    public void startAIShowButton() throws Exception {
        Parent aiShowLayout = FXMLLoader.load(Main.class.getResource("/resources/aiShowScene.fxml"));
        Main.setMainMenuScene(new Scene(aiShowLayout));
        Main.startAIShowMode();
    }

    /**
     * 系统退出方法。
     */
    public void quitButton() {
        System.exit(0);
    }

    /**
     * 回到主界面的方法。
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
     * 改变按钮颜色的方法。
     *
     * @param key   按钮键值
     * @param color 颜色
     */
    public void changeButtonColor(char key,int color) {
        AdvanceScene.changeButtonColor(key, color, ButtonQ, ButtonW, ButtonE, ButtonR, ButtonT, ButtonY, ButtonU, ButtonI, ButtonO, ButtonP, ButtonA, ButtonS, ButtonD, ButtonF, ButtonG, ButtonH, ButtonJ, ButtonK, ButtonL, ButtonZ, ButtonX, ButtonC, ButtonV, ButtonB, ButtonN, ButtonM);
    }

    /**
     * 屏幕键盘输入Q
     *
     * @throws Exception 异常
     */
    public void inputQ() throws Exception{
        Main.inputQ();
    }

    /**
     * 屏幕键盘输入W
     *
     * @throws Exception 异常
     */
    public void inputW() throws Exception{
        Main.inputW();
    }

    /**
     * 屏幕键盘输入E
     *
     * @throws Exception 异常
     */
    public void inputE() throws Exception{
        Main.inputE();
    }

    /**
     * 屏幕键盘输入R
     *
     * @throws Exception 异常
     */
    public void inputR() throws Exception{
        Main.inputR();
    }

    /**
     * 屏幕键盘输入T
     *
     * @throws Exception 异常
     */
    public void inputT() throws Exception{
        Main.inputT();
    }

    /**
     * 屏幕键盘输入Y
     *
     * @throws Exception 异常
     */
    public void inputY() throws Exception{
        Main.inputY();
    }

    /**
     * 屏幕键盘输入U
     *
     * @throws Exception 异常
     */
    public void inputU() throws Exception{
        Main.inputU();
    }

    /**
     * 屏幕键盘输入I
     *
     * @throws Exception 异常
     */
    public void inputI() throws Exception{
        Main.inputI();
    }

    /**
     * 屏幕键盘输入O
     *
     * @throws Exception 异常
     */
    public void inputO() throws Exception{
        Main.inputO();
    }

    /**
     * 屏幕键盘输入P
     *
     * @throws Exception 异常
     */
    public void inputP() throws Exception{
        Main.inputP();
    }

    /**
     * 屏幕键盘输入A
     *
     * @throws Exception 异常
     */
    public void inputA() throws Exception{
        Main.inputA();
    }

    /**
     * 屏幕键盘输入S
     *
     * @throws Exception 异常
     */
    public void inputS() throws Exception{
        Main.inputS();
    }

    /**
     * 屏幕键盘输入D
     *
     * @throws Exception 异常
     */
    public void inputD() throws Exception{
        Main.inputD();
    }

    /**
     * 屏幕键盘输入F
     *
     * @throws Exception 异常
     */
    public void inputF() throws Exception{
        Main.inputF();
    }

    /**
     * 屏幕键盘输入G
     *
     * @throws Exception 异常
     */
    public void inputG() throws Exception{
        Main.inputG();
    }

    /**
     * 屏幕键盘输入H
     *
     * @throws Exception 异常
     */
    public void inputH() throws Exception{
        Main.inputH();
    }

    /**
     * 屏幕键盘输入J
     *
     * @throws Exception 异常
     */
    public void inputJ() throws Exception{
        Main.inputJ();
    }

    /**
     * 屏幕键盘输入K
     *
     * @throws Exception 异常
     */
    public void inputK() throws Exception{
        Main.inputK();
    }

    /**
     * 屏幕键盘输入L
     *
     * @throws Exception 异常
     */
    public void inputL() throws Exception{
        Main.inputL();
    }

    /**
     * 屏幕键盘输入Z
     *
     * @throws Exception 异常
     */
    public void inputZ() throws Exception{
        Main.inputZ();
    }

    /**
     * 屏幕键盘输入X
     *
     * @throws Exception 异常
     */
    public void inputX() throws Exception{
        Main.inputX();
    }

    /**
     * 屏幕键盘输入C
     *
     * @throws Exception 异常
     */
    public void inputC() throws Exception{
        Main.inputC();
    }

    /**
     * 屏幕键盘输入V
     *
     * @throws Exception 异常
     */
    public void inputV() throws Exception{
        Main.inputV();
    }

    /**
     * 屏幕键盘输入B
     *
     * @throws Exception 异常
     */
    public void inputB() throws Exception{
        Main.inputB();
    }

    /**
     * 屏幕键盘输入N
     *
     * @throws Exception 异常
     */
    public void inputN() throws Exception{
        Main.inputN();
    }

    /**
     * 屏幕键盘输入M
     *
     * @throws Exception 异常
     */
    public void inputM() throws Exception{
        Main.inputM();
    }

    /**
     * 屏幕键盘输入退格
     */
    public void backSpace() {
        Main.backSpace();
    }

    /**
     * 屏幕键盘输入回车
     */
    public void mainEnter() {
        Main.mainEnter();
    }
}
