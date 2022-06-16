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
 * 菜单场景
 *
 * @author 86153
 * @date 2022/06/16
 */
public class MenuScene {

    /**
     * img回来
     */
    @FXML
    private ImageView backImg;

    /**
     * buttonq
     */
    @FXML
    private Button ButtonQ;

    /**
     * buttonw
     */
    @FXML
    private Button ButtonW;

    /**
     * buttone
     */
    @FXML
    private Button ButtonE;

    /**
     * buttonr
     */
    @FXML
    private Button ButtonR;

    /**
     * buttont
     */
    @FXML
    private Button ButtonT;

    /**
     * 钮扣状
     */
    @FXML
    private Button ButtonY;

    /**
     * buttonu
     */
    @FXML
    private Button ButtonU;

    /**
     * buttoni
     */
    @FXML
    private Button ButtonI;

    /**
     * buttono
     */
    @FXML
    private Button ButtonO;

    /**
     * buttonp
     */
    @FXML
    private Button ButtonP;

    /**
     * buttona
     */
    @FXML
    private Button ButtonA;

    /**
     * 按钮
     */
    @FXML
    private Button ButtonS;

    /**
     * buttond
     */
    @FXML
    private Button ButtonD;

    /**
     * buttonf
     */
    @FXML
    private Button ButtonF;

    /**
     * buttong
     */
    @FXML
    private Button ButtonG;

    /**
     * buttonh
     */
    @FXML
    private Button ButtonH;

    /**
     * buttonj
     */
    @FXML
    private Button ButtonJ;

    /**
     * buttonk
     */
    @FXML
    private Button ButtonK;

    /**
     * buttonl
     */
    @FXML
    private Button ButtonL;

    /**
     * buttonz
     */
    @FXML
    private Button ButtonZ;

    /**
     * buttonx
     */
    @FXML
    private Button ButtonX;

    /**
     * buttonc
     */
    @FXML
    private Button ButtonC;

    /**
     * buttonv
     */
    @FXML
    private Button ButtonV;

    /**
     * buttonb
     */
    @FXML
    private Button ButtonB;

    /**
     * buttonn
     */
    @FXML
    private Button ButtonN;

    /**
     * buttonm
     */
    @FXML
    private Button ButtonM;

    /**
     * 按钮进入
     */
    @FXML
    private Button ButtonENTER;

    /**
     * 按钮退格
     */
    @FXML
    private Button ButtonBackspace;

    /**
     * 正常模式
     */
    @FXML
    private Text normalMode;

    /**
     * 推进模式
     */
    @FXML
    private Text advanceMode;

    /**
     * aishow
     */
    @FXML
    private Text AIShow;

    /**
     * 辞职
     */
    @FXML
    private Text quit;

    /**
     * 帮助img
     */
    @FXML
    private ImageView helpImg;

    /**
     * 帮助按钮
     */
    @FXML
    private Button helpButton;

    /**
     * 鼠标正常按钮
     * 当鼠标进入按钮区域改变鼠标样式的方法。
     */
    public void mouseOnNormalButton(){
       // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        normalMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        normalMode.setX(-20);
    }

    /**
     * 鼠标离开正常按钮
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveNormalButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        normalMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        normalMode.setX(5);
      }

    /**
     * 老鼠前进按钮上
     */
    public void mouseOnAdvanceButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        advanceMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        advanceMode.setX(-20);
    }

    /**
     * 鼠标离开前进按钮
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveAdvanceButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        advanceMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        advanceMode.setX(5);
    }

    /**
     * 鼠标在aibutton
     */
    public void mouseOnAIButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        AIShow.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        AIShow.setX(-20);
    }

    /**
     * 鼠标离开aibutton
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveAIButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        AIShow.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        AIShow.setX(5);
    }

    /**
     * 鼠标退出按钮
     */
    public void mouseOnQuitButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        quit.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        quit.setX(-10);
    }

    /**
     * 鼠标离开退出按钮
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveQuitButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        quit.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        quit.setX(5);
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
     * 鼠标在帮助img
     */
    public void mouseOnHelpImg(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        helpImg.setImage(new Image("rule1.png"));
    }

    /**
     * 鼠标离开帮助img
     */
    public void mouseLeaveHelpImg(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        helpImg.setImage(new Image("rule.png"));
    }

    /**
     * 开始正常按钮
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
     * 统治
     *
     * @throws Exception 异常
     */
    public void toRule() throws Exception{
        Parent ruleLayout = FXMLLoader.load(Main.class.getResource("/resources/basicRule.fxml"));
        Main.setMainMenuScene(new Scene(ruleLayout));
        Main.toRuleView();
    }

    /**
     * 开始前进按钮
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
     * 开始aishow按钮
     *
     * @throws Exception 异常
     */
    public void startAIShowButton() throws Exception {
        Parent aiShowLayout = FXMLLoader.load(Main.class.getResource("/resources/aiShowScene.fxml"));
        Main.setMainMenuScene(new Scene(aiShowLayout));
        Main.startAIShowMode();
    }

    /**
     * 退出按钮
     */
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

    /**
     * 改变按钮颜色
     *
     * @param key   关键
     * @param color 颜色
     */
    public void changeButtonColor(char key,int color) {
        AdvanceScene.changeButtonColor(key, color, ButtonQ, ButtonW, ButtonE, ButtonR, ButtonT, ButtonY, ButtonU, ButtonI, ButtonO, ButtonP, ButtonA, ButtonS, ButtonD, ButtonF, ButtonG, ButtonH, ButtonJ, ButtonK, ButtonL, ButtonZ, ButtonX, ButtonC, ButtonV, ButtonB, ButtonN, ButtonM);
    }

    /**
     * inputq
     *
     * @throws Exception 异常
     */
    public void inputQ() throws Exception{
        Main.inputQ();
    }

    /**
     * inputw
     *
     * @throws Exception 异常
     */
    public void inputW() throws Exception{
        Main.inputW();
    }

    /**
     * inpute
     *
     * @throws Exception 异常
     */
    public void inputE() throws Exception{
        Main.inputE();
    }

    /**
     * inputr
     *
     * @throws Exception 异常
     */
    public void inputR() throws Exception{
        Main.inputR();
    }

    /**
     * inputt
     *
     * @throws Exception 异常
     */
    public void inputT() throws Exception{
        Main.inputT();
    }

    /**
     * inputy
     *
     * @throws Exception 异常
     */
    public void inputY() throws Exception{
        Main.inputY();
    }

    /**
     * inputu
     *
     * @throws Exception 异常
     */
    public void inputU() throws Exception{
        Main.inputU();
    }

    /**
     * inputi
     *
     * @throws Exception 异常
     */
    public void inputI() throws Exception{
        Main.inputI();
    }

    /**
     * inputo
     *
     * @throws Exception 异常
     */
    public void inputO() throws Exception{
        Main.inputO();
    }

    /**
     * inputp
     *
     * @throws Exception 异常
     */
    public void inputP() throws Exception{
        Main.inputP();
    }

    /**
     * inputa
     *
     * @throws Exception 异常
     */
    public void inputA() throws Exception{
        Main.inputA();
    }

    /**
     * 输入
     *
     * @throws Exception 异常
     */
    public void inputS() throws Exception{
        Main.inputS();
    }

    /**
     * inputd
     *
     * @throws Exception 异常
     */
    public void inputD() throws Exception{
        Main.inputD();
    }

    /**
     * inputf
     *
     * @throws Exception 异常
     */
    public void inputF() throws Exception{
        Main.inputF();
    }

    /**
     * inputg
     *
     * @throws Exception 异常
     */
    public void inputG() throws Exception{
        Main.inputG();
    }

    /**
     * inputh
     *
     * @throws Exception 异常
     */
    public void inputH() throws Exception{
        Main.inputH();
    }

    /**
     * inputj
     *
     * @throws Exception 异常
     */
    public void inputJ() throws Exception{
        Main.inputJ();
    }

    /**
     * inputk
     *
     * @throws Exception 异常
     */
    public void inputK() throws Exception{
        Main.inputK();
    }

    /**
     * inputl
     *
     * @throws Exception 异常
     */
    public void inputL() throws Exception{
        Main.inputL();
    }

    /**
     * inputz
     *
     * @throws Exception 异常
     */
    public void inputZ() throws Exception{
        Main.inputZ();
    }

    /**
     * inputx
     *
     * @throws Exception 异常
     */
    public void inputX() throws Exception{
        Main.inputX();
    }

    /**
     * inputc
     *
     * @throws Exception 异常
     */
    public void inputC() throws Exception{
        Main.inputC();
    }

    /**
     * inputv
     *
     * @throws Exception 异常
     */
    public void inputV() throws Exception{
        Main.inputV();
    }

    /**
     * inputb
     *
     * @throws Exception 异常
     */
    public void inputB() throws Exception{
        Main.inputB();
    }

    /**
     * inputn
     *
     * @throws Exception 异常
     */
    public void inputN() throws Exception{
        Main.inputN();
    }

    /**
     * inputm
     *
     * @throws Exception 异常
     */
    public void inputM() throws Exception{
        Main.inputM();
    }

    /**
     * 退格
     */
    public void backSpace() {
        Main.backSpace();
    }

    /**
     * 主要输入
     */
    public void mainEnter() {
        Main.mainEnter();
    }
}
