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
 * �˵�����
 *
 * @author 86153
 * @date 2022/06/16
 */
public class MenuScene {

    /**
     * img����
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
     * ť��״
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
     * ��ť
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
     * ��ť����
     */
    @FXML
    private Button ButtonENTER;

    /**
     * ��ť�˸�
     */
    @FXML
    private Button ButtonBackspace;

    /**
     * ����ģʽ
     */
    @FXML
    private Text normalMode;

    /**
     * �ƽ�ģʽ
     */
    @FXML
    private Text advanceMode;

    /**
     * aishow
     */
    @FXML
    private Text AIShow;

    /**
     * ��ְ
     */
    @FXML
    private Text quit;

    /**
     * ����img
     */
    @FXML
    private ImageView helpImg;

    /**
     * ������ť
     */
    @FXML
    private Button helpButton;

    /**
     * ���������ť
     * �������밴ť����ı������ʽ�ķ�����
     */
    public void mouseOnNormalButton(){
       // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        normalMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        normalMode.setX(-20);
    }

    /**
     * ����뿪������ť
     * ������뿪��ť����ı������ʽ�ķ�����
     */
    public void mouseLeaveNormalButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        normalMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        normalMode.setX(5);
      }

    /**
     * ����ǰ����ť��
     */
    public void mouseOnAdvanceButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        advanceMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        advanceMode.setX(-20);
    }

    /**
     * ����뿪ǰ����ť
     * ������뿪��ť����ı������ʽ�ķ�����
     */
    public void mouseLeaveAdvanceButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        advanceMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        advanceMode.setX(5);
    }

    /**
     * �����aibutton
     */
    public void mouseOnAIButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        AIShow.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        AIShow.setX(-20);
    }

    /**
     * ����뿪aibutton
     * ������뿪��ť����ı������ʽ�ķ�����
     */
    public void mouseLeaveAIButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        AIShow.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        AIShow.setX(5);
    }

    /**
     * ����˳���ť
     */
    public void mouseOnQuitButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        quit.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        quit.setX(-10);
    }

    /**
     * ����뿪�˳���ť
     * ������뿪��ť����ı������ʽ�ķ�����
     */
    public void mouseLeaveQuitButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        quit.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        quit.setX(5);
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
     * ����ڰ���img
     */
    public void mouseOnHelpImg(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        helpImg.setImage(new Image("rule1.png"));
    }

    /**
     * ����뿪����img
     */
    public void mouseLeaveHelpImg(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        helpImg.setImage(new Image("rule.png"));
    }

    /**
     * ��ʼ������ť
     * ��ʼ��ͨģʽ�ķ�����
     *
     * @throws Exception �쳣
     */
    public void startNormalButton() throws Exception {
        Parent normalLayout = FXMLLoader.load(Main.class.getResource("/resources/mainScene.fxml"));
        Main.setMainMenuScene(new Scene(normalLayout));
        Main.startNormalMode();
    }

    /**
     * ͳ��
     *
     * @throws Exception �쳣
     */
    public void toRule() throws Exception{
        Parent ruleLayout = FXMLLoader.load(Main.class.getResource("/resources/basicRule.fxml"));
        Main.setMainMenuScene(new Scene(ruleLayout));
        Main.toRuleView();
    }

    /**
     * ��ʼǰ����ť
     * ��ʼ����ģʽ�ķ�����
     *
     * @throws Exception �쳣
     */
    public void startAdvanceButton() throws Exception {
        Parent advanceLayout = FXMLLoader.load(Main.class.getResource("/resources/advanceScene.fxml"));
        Main.setMainMenuScene(new Scene(advanceLayout));
        Main.startAdvanceMode();
    }

    /**
     * ��ʼaishow��ť
     *
     * @throws Exception �쳣
     */
    public void startAIShowButton() throws Exception {
        Parent aiShowLayout = FXMLLoader.load(Main.class.getResource("/resources/aiShowScene.fxml"));
        Main.setMainMenuScene(new Scene(aiShowLayout));
        Main.startAIShowMode();
    }

    /**
     * �˳���ť
     */
    public void quitButton() {
        System.exit(0);
    }

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
     * �ı䰴ť��ɫ
     *
     * @param key   �ؼ�
     * @param color ��ɫ
     */
    public void changeButtonColor(char key,int color) {
        AdvanceScene.changeButtonColor(key, color, ButtonQ, ButtonW, ButtonE, ButtonR, ButtonT, ButtonY, ButtonU, ButtonI, ButtonO, ButtonP, ButtonA, ButtonS, ButtonD, ButtonF, ButtonG, ButtonH, ButtonJ, ButtonK, ButtonL, ButtonZ, ButtonX, ButtonC, ButtonV, ButtonB, ButtonN, ButtonM);
    }

    /**
     * inputq
     *
     * @throws Exception �쳣
     */
    public void inputQ() throws Exception{
        Main.inputQ();
    }

    /**
     * inputw
     *
     * @throws Exception �쳣
     */
    public void inputW() throws Exception{
        Main.inputW();
    }

    /**
     * inpute
     *
     * @throws Exception �쳣
     */
    public void inputE() throws Exception{
        Main.inputE();
    }

    /**
     * inputr
     *
     * @throws Exception �쳣
     */
    public void inputR() throws Exception{
        Main.inputR();
    }

    /**
     * inputt
     *
     * @throws Exception �쳣
     */
    public void inputT() throws Exception{
        Main.inputT();
    }

    /**
     * inputy
     *
     * @throws Exception �쳣
     */
    public void inputY() throws Exception{
        Main.inputY();
    }

    /**
     * inputu
     *
     * @throws Exception �쳣
     */
    public void inputU() throws Exception{
        Main.inputU();
    }

    /**
     * inputi
     *
     * @throws Exception �쳣
     */
    public void inputI() throws Exception{
        Main.inputI();
    }

    /**
     * inputo
     *
     * @throws Exception �쳣
     */
    public void inputO() throws Exception{
        Main.inputO();
    }

    /**
     * inputp
     *
     * @throws Exception �쳣
     */
    public void inputP() throws Exception{
        Main.inputP();
    }

    /**
     * inputa
     *
     * @throws Exception �쳣
     */
    public void inputA() throws Exception{
        Main.inputA();
    }

    /**
     * ����
     *
     * @throws Exception �쳣
     */
    public void inputS() throws Exception{
        Main.inputS();
    }

    /**
     * inputd
     *
     * @throws Exception �쳣
     */
    public void inputD() throws Exception{
        Main.inputD();
    }

    /**
     * inputf
     *
     * @throws Exception �쳣
     */
    public void inputF() throws Exception{
        Main.inputF();
    }

    /**
     * inputg
     *
     * @throws Exception �쳣
     */
    public void inputG() throws Exception{
        Main.inputG();
    }

    /**
     * inputh
     *
     * @throws Exception �쳣
     */
    public void inputH() throws Exception{
        Main.inputH();
    }

    /**
     * inputj
     *
     * @throws Exception �쳣
     */
    public void inputJ() throws Exception{
        Main.inputJ();
    }

    /**
     * inputk
     *
     * @throws Exception �쳣
     */
    public void inputK() throws Exception{
        Main.inputK();
    }

    /**
     * inputl
     *
     * @throws Exception �쳣
     */
    public void inputL() throws Exception{
        Main.inputL();
    }

    /**
     * inputz
     *
     * @throws Exception �쳣
     */
    public void inputZ() throws Exception{
        Main.inputZ();
    }

    /**
     * inputx
     *
     * @throws Exception �쳣
     */
    public void inputX() throws Exception{
        Main.inputX();
    }

    /**
     * inputc
     *
     * @throws Exception �쳣
     */
    public void inputC() throws Exception{
        Main.inputC();
    }

    /**
     * inputv
     *
     * @throws Exception �쳣
     */
    public void inputV() throws Exception{
        Main.inputV();
    }

    /**
     * inputb
     *
     * @throws Exception �쳣
     */
    public void inputB() throws Exception{
        Main.inputB();
    }

    /**
     * inputn
     *
     * @throws Exception �쳣
     */
    public void inputN() throws Exception{
        Main.inputN();
    }

    /**
     * inputm
     *
     * @throws Exception �쳣
     */
    public void inputM() throws Exception{
        Main.inputM();
    }

    /**
     * �˸�
     */
    public void backSpace() {
        Main.backSpace();
    }

    /**
     * ��Ҫ����
     */
    public void mainEnter() {
        Main.mainEnter();
    }
}
