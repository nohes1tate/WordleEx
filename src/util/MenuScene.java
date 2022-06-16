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
 * �����ؼ�������
 */
public class MenuScene {

    /**
     * ����ͼ��
     */
    @FXML
    private ImageView backImg;

    /**
     * ��Ļ���̰�ťQ
     */
    @FXML
    private Button ButtonQ;

    /**
     * ��Ļ���̰�ťW
     */
    @FXML
    private Button ButtonW;

    /**
     * ��Ļ���̰�ťE
     */
    @FXML
    private Button ButtonE;

    /**
     * ��Ļ���̰�ťR
     */
    @FXML
    private Button ButtonR;

    /**
     * ��Ļ���̰�ťT
     */
    @FXML
    private Button ButtonT;

    /**
     * ��Ļ���̰�ťY
     */
    @FXML
    private Button ButtonY;

    /**
     * ��Ļ���̰�ťU
     */
    @FXML
    private Button ButtonU;

    /**
     * ��Ļ���̰�ťI
     */
    @FXML
    private Button ButtonI;

    /**
     * ��Ļ���̰�ťO
     */
    @FXML
    private Button ButtonO;

    /**
     * ��Ļ���̰�ťP
     */
    @FXML
    private Button ButtonP;

    /**
     * ��Ļ���̰�ťIA
     */
    @FXML
    private Button ButtonA;

    /**
     * ��Ļ���̰�ťS
     */
    @FXML
    private Button ButtonS;

    /**
     * ��Ļ���̰�ťD
     */
    @FXML
    private Button ButtonD;

    /**
     * ��Ļ���̰�ťF
     */
    @FXML
    private Button ButtonF;

    /**
     * ��Ļ���̰�ťG
     */
    @FXML
    private Button ButtonG;

    /**
     * ��Ļ���̰�ťH
     */
    @FXML
    private Button ButtonH;

    /**
     * ��Ļ���̰�ťJ
     */
    @FXML
    private Button ButtonJ;

    /**
     * ��Ļ���̰�ťK
     */
    @FXML
    private Button ButtonK;

    /**
     * ��Ļ���̰�ťL
     */
    @FXML
    private Button ButtonL;

    /**
     * ��Ļ���̰�ťZ
     */
    @FXML
    private Button ButtonZ;

    /**
     * ��Ļ���̰�ťX
     */
    @FXML
    private Button ButtonX;

    /**
     * ��Ļ���̰�ťC
     */
    @FXML
    private Button ButtonC;

    /**
     * ��Ļ���̰�ťV
     */
    @FXML
    private Button ButtonV;

    /**
     * ��Ļ���̰�ťB
     */
    @FXML
    private Button ButtonB;

    /**
     * ��Ļ���̰�ťN
     */
    @FXML
    private Button ButtonN;

    /**
     * ��Ļ���̰�ťM
     */
    @FXML
    private Button ButtonM;

    /**
     * ��Ļ���̻س���ť
     */
    @FXML
    private Button ButtonENTER;

    /**
     * ��Ļ�����˸�ť
     */
    @FXML
    private Button ButtonBackspace;

    /**
     * ����ģʽ�ı�
     */
    @FXML
    private Text normalMode;

    /**
     * ����ģʽ�ı�
     */
    @FXML
    private Text advanceMode;

    /**
     * AI��ʾ�ı�
     */
    @FXML
    private Text AIShow;

    /**
     * �˳��ı�
     */
    @FXML
    private Text quit;

    /**
     * ����ͼ��
     */
    @FXML
    private ImageView helpImg;

    /**
     * ������ť
     */
    @FXML
    private Button helpButton;

    /**
     * ���������ģʽ��ť���ı�����ķ�����
     */
    public void mouseOnNormalButton(){
       // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        normalMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        normalMode.setX(-20);
    }

    /**
     * ����뿪����ģʽ��ť�ı�����ķ�����
     */
    public void mouseLeaveNormalButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        normalMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        normalMode.setX(5);
      }

    /**
     * ����ڽ���ģʽ��ť���ı�����ķ�����
     */
    public void mouseOnAdvanceButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        advanceMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        advanceMode.setX(-20);
    }

    /**
     * ����뿪����ģʽ��ť�ı�����ķ�����
     */
    public void mouseLeaveAdvanceButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        advanceMode.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        advanceMode.setX(5);
    }

    /**
     * �����AI��ʾģʽ��ť���ı�����ķ�����
     */
    public void mouseOnAIButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        AIShow.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        AIShow.setX(-20);
    }

    /**
     * ����뿪AI��ʾģʽ��ť�ı�����ķ�����
     */
    public void mouseLeaveAIButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        AIShow.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        AIShow.setX(5);
    }

    /**
     * ������˳���ť���ı�����ķ�����
     */
    public void mouseOnQuitButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        quit.setFont(Font.font("Lucida Fax", FontWeight.BOLD,65));
        quit.setX(-10);
    }

    /**
     * ����뿪�˳���ť�ı�����ķ�����
     */
    public void mouseLeaveQuitButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        quit.setFont(Font.font("Lucida Fax", FontWeight.BOLD,55));
        quit.setX(5);
    }

    /**
     * ����ڷ��ذ�ťͼƬ�仯�ķ�����
     */
    public void mouseOnBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        backImg.setImage(new Image("arrow1.png"));
    }

    /**
     * ����뿪���ذ�ťͼƬ�仯�ķ�����
     */
    public void mouseLeaveBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        backImg.setImage(new Image("arrow.png"));
    }

    /**
     * ����ڰ���ͼ����ͼƬ�仯�ķ�����
     */
    public void mouseOnHelpImg(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        helpImg.setImage(new Image("rule1.png"));
    }

    /**
     * ����뿪����ͼ��ͼƬ�仯�ķ�����
     */
    public void mouseLeaveHelpImg(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        helpImg.setImage(new Image("rule.png"));
    }

    /**
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
     * �������˵���ķ�����
     *
     * @throws Exception �쳣
     */
    public void toRule() throws Exception{
        Parent ruleLayout = FXMLLoader.load(Main.class.getResource("/resources/basicRule.fxml"));
        Main.setMainMenuScene(new Scene(ruleLayout));
        Main.toRuleView();
    }

    /**
     * �������ģʽ�ķ�����
     *
     * @throws Exception �쳣
     */
    public void startAdvanceButton() throws Exception {
        Parent advanceLayout = FXMLLoader.load(Main.class.getResource("/resources/advanceScene.fxml"));
        Main.setMainMenuScene(new Scene(advanceLayout));
        Main.startAdvanceMode();
    }

    /**
     * ����AI��ʾģʽ�ķ���
     *
     * @throws Exception �쳣
     */
    public void startAIShowButton() throws Exception {
        Parent aiShowLayout = FXMLLoader.load(Main.class.getResource("/resources/aiShowScene.fxml"));
        Main.setMainMenuScene(new Scene(aiShowLayout));
        Main.startAIShowMode();
    }

    /**
     * ϵͳ�˳�������
     */
    public void quitButton() {
        System.exit(0);
    }

    /**
     * �ص�������ķ�����
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
     * �ı䰴ť��ɫ�ķ�����
     *
     * @param key   ��ť��ֵ
     * @param color ��ɫ
     */
    public void changeButtonColor(char key,int color) {
        AdvanceScene.changeButtonColor(key, color, ButtonQ, ButtonW, ButtonE, ButtonR, ButtonT, ButtonY, ButtonU, ButtonI, ButtonO, ButtonP, ButtonA, ButtonS, ButtonD, ButtonF, ButtonG, ButtonH, ButtonJ, ButtonK, ButtonL, ButtonZ, ButtonX, ButtonC, ButtonV, ButtonB, ButtonN, ButtonM);
    }

    /**
     * ��Ļ��������Q
     *
     * @throws Exception �쳣
     */
    public void inputQ() throws Exception{
        Main.inputQ();
    }

    /**
     * ��Ļ��������W
     *
     * @throws Exception �쳣
     */
    public void inputW() throws Exception{
        Main.inputW();
    }

    /**
     * ��Ļ��������E
     *
     * @throws Exception �쳣
     */
    public void inputE() throws Exception{
        Main.inputE();
    }

    /**
     * ��Ļ��������R
     *
     * @throws Exception �쳣
     */
    public void inputR() throws Exception{
        Main.inputR();
    }

    /**
     * ��Ļ��������T
     *
     * @throws Exception �쳣
     */
    public void inputT() throws Exception{
        Main.inputT();
    }

    /**
     * ��Ļ��������Y
     *
     * @throws Exception �쳣
     */
    public void inputY() throws Exception{
        Main.inputY();
    }

    /**
     * ��Ļ��������U
     *
     * @throws Exception �쳣
     */
    public void inputU() throws Exception{
        Main.inputU();
    }

    /**
     * ��Ļ��������I
     *
     * @throws Exception �쳣
     */
    public void inputI() throws Exception{
        Main.inputI();
    }

    /**
     * ��Ļ��������O
     *
     * @throws Exception �쳣
     */
    public void inputO() throws Exception{
        Main.inputO();
    }

    /**
     * ��Ļ��������P
     *
     * @throws Exception �쳣
     */
    public void inputP() throws Exception{
        Main.inputP();
    }

    /**
     * ��Ļ��������A
     *
     * @throws Exception �쳣
     */
    public void inputA() throws Exception{
        Main.inputA();
    }

    /**
     * ��Ļ��������S
     *
     * @throws Exception �쳣
     */
    public void inputS() throws Exception{
        Main.inputS();
    }

    /**
     * ��Ļ��������D
     *
     * @throws Exception �쳣
     */
    public void inputD() throws Exception{
        Main.inputD();
    }

    /**
     * ��Ļ��������F
     *
     * @throws Exception �쳣
     */
    public void inputF() throws Exception{
        Main.inputF();
    }

    /**
     * ��Ļ��������G
     *
     * @throws Exception �쳣
     */
    public void inputG() throws Exception{
        Main.inputG();
    }

    /**
     * ��Ļ��������H
     *
     * @throws Exception �쳣
     */
    public void inputH() throws Exception{
        Main.inputH();
    }

    /**
     * ��Ļ��������J
     *
     * @throws Exception �쳣
     */
    public void inputJ() throws Exception{
        Main.inputJ();
    }

    /**
     * ��Ļ��������K
     *
     * @throws Exception �쳣
     */
    public void inputK() throws Exception{
        Main.inputK();
    }

    /**
     * ��Ļ��������L
     *
     * @throws Exception �쳣
     */
    public void inputL() throws Exception{
        Main.inputL();
    }

    /**
     * ��Ļ��������Z
     *
     * @throws Exception �쳣
     */
    public void inputZ() throws Exception{
        Main.inputZ();
    }

    /**
     * ��Ļ��������X
     *
     * @throws Exception �쳣
     */
    public void inputX() throws Exception{
        Main.inputX();
    }

    /**
     * ��Ļ��������C
     *
     * @throws Exception �쳣
     */
    public void inputC() throws Exception{
        Main.inputC();
    }

    /**
     * ��Ļ��������V
     *
     * @throws Exception �쳣
     */
    public void inputV() throws Exception{
        Main.inputV();
    }

    /**
     * ��Ļ��������B
     *
     * @throws Exception �쳣
     */
    public void inputB() throws Exception{
        Main.inputB();
    }

    /**
     * ��Ļ��������N
     *
     * @throws Exception �쳣
     */
    public void inputN() throws Exception{
        Main.inputN();
    }

    /**
     * ��Ļ��������M
     *
     * @throws Exception �쳣
     */
    public void inputM() throws Exception{
        Main.inputM();
    }

    /**
     * ��Ļ���������˸�
     */
    public void backSpace() {
        Main.backSpace();
    }

    /**
     * ��Ļ��������س�
     */
    public void mainEnter() {
        Main.mainEnter();
    }
}
