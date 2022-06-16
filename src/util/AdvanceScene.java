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

/**
 * ǰ����
 *
 * @author 86153
 * @date 2022/06/16
 */
public class AdvanceScene {

    /**
     * ���ذ�ťͼ��
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
     * ��Ļ���̰�ťA
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
     * ��Ļ���̰�ťEnter
     */
    @FXML
    private Button ButtonENTER;

    /**
     * ��Ļ���̰�ťBackspace
     */
    @FXML
    private Button ButtonBackspace;

    /**
     * ������ڷ��ذ�ť��ʱ�ı����ָ���Ұ�ť��ɫ
     */
    public void mouseOnBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        backImg.setImage(new Image("arrow1.png"));
    }

    /**
     * ������뿪��ťʱ�ı����ָ���Ұ�ť��ɫ
     */
    public void mouseLeaveBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        backImg.setImage(new Image("arrow.png"));
    }

    /**
     * �ص��˵�ҳ��
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
        changeButtonColor(key, color, ButtonQ, ButtonW, ButtonE, ButtonR, ButtonT, ButtonY, ButtonU, ButtonI, ButtonO, ButtonP, ButtonA, ButtonS, ButtonD, ButtonF, ButtonG, ButtonH, ButtonJ, ButtonK, ButtonL, ButtonZ, ButtonX, ButtonC, ButtonV, ButtonB, ButtonN, ButtonM);
    }

    /**
     * ����ı䰴ť��ɫ
     *
     * @param key     �ؼ�
     * @param color   ��ɫ
     */
    static void changeButtonColor(char key, int color, Button buttonQ, Button buttonW, Button buttonE, Button buttonR, Button buttonT, Button buttonY, Button buttonU, Button buttonI, Button buttonO, Button buttonP, Button buttonA, Button buttonS, Button buttonD, Button buttonF, Button buttonG, Button buttonH, Button buttonJ, Button buttonK, Button buttonL, Button buttonZ, Button buttonX, Button buttonC, Button buttonV, Button buttonB, Button buttonN, Button buttonM) {
        System.out.print(key);
        if(key=='q')
        {
            buttonColor(color, buttonQ);
        }
        else if(key=='w')
        {
            buttonColor(color, buttonW);
        }
        else if(key=='e')
        {
            buttonColor(color, buttonE);
        }
        else if(key=='r')
        {
            buttonColor(color, buttonR);
        }
        else if(key=='t')
        {
            buttonColor(color, buttonT);
        }
        else if(key=='y')
        {
            buttonColor(color, buttonY);
        }
        else if(key=='u')
        {
            buttonColor(color, buttonU);
        }
        else if(key=='i')
        {
            buttonColor(color, buttonI);
        }
        else if(key=='o')
        {
            buttonColor(color, buttonO);
        }
        else if(key=='p')
        {
            buttonColor(color, buttonP);
        }
        else if(key=='a')
        {
            buttonColor(color, buttonA);
        }
        else if(key=='s')
        {
            buttonColor(color, buttonS);
        }
        else if(key=='d')
        {
            buttonColor(color, buttonD);
        }
        else if(key=='f')
        {
            buttonColor(color, buttonF);
        }
        else if(key=='g')
        {
            buttonColor(color, buttonG);
        }
        else if(key=='h')
        {
            buttonColor(color, buttonH);
        }
        else if(key=='j')
        {
            buttonColor(color, buttonJ);
        }
        else if(key=='k')
        {
            buttonColor(color, buttonK);
        }
        else if(key=='l')
        {
            buttonColor(color, buttonL);
        }
        else if(key=='z')
        {
            buttonColor(color, buttonZ);
        }
        else if(key=='x')
        {
            buttonColor(color, buttonX);
        }
        else if(key=='c')
        {
            buttonColor(color, buttonC);
        }
        else if(key=='v')
        {
            buttonColor(color, buttonV);
        }
        else if(key=='b')
        {
            buttonColor(color, buttonB);
        }
        else if(key=='n')
        {
            buttonColor(color, buttonN);
        }
        else if(key=='m')
        {
            buttonColor(color, buttonM);
        }
    }

    /**
     * �ı�ĳ����ť��ɫ
     *
     * @param color  ��ɫ
     * @param button ��ť
     */
    private static void buttonColor(int color, Button button) {
        if(color==1)
        {
            BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
            Background background = new Background(background_fill);
            button.setBackground(background);
            button.setTextFill(Paint.valueOf("#ffffff"));
        }
        else if(color==2)
        {
            BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
            Background background = new Background(background_fill);
            button.setBackground(background);
        }
        else if(color==3)
        {
            BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
            Background background = new Background(background_fill);
            button.setBackground(background);
            button.setTextFill(Paint.valueOf("#ffffff"));
        }
    }

    /**
     * ��Ӧ��Ļ���̰�ťQ����
     *
     * @throws Exception �쳣
     */
    public void inputQ() throws Exception{
        Main.inputQ();
    }

    /**
     * ��Ӧ��Ļ���̰�ťW����
     *
     * @throws Exception �쳣
     */
    public void inputW() throws Exception{
        Main.inputW();
    }

    /**
     * ��Ӧ��Ļ���̰�ťE����
     *
     * @throws Exception �쳣
     */
    public void inputE() throws Exception{
        Main.inputE();
    }

    /**
     * ��Ӧ��Ļ���̰�ťR����
     *
     * @throws Exception �쳣
     */
    public void inputR() throws Exception{
        Main.inputR();
    }

    /**
     * ��Ӧ��Ļ���̰�ťT����
     *
     * @throws Exception �쳣
     */
    public void inputT() throws Exception{
        Main.inputT();
    }

    /**
     * ��Ӧ��Ļ���̰�ťY����
     *
     * @throws Exception �쳣
     */
    public void inputY() throws Exception{
        Main.inputY();
    }

    /**
     * ��Ӧ��Ļ���̰�ťU����
     *
     * @throws Exception �쳣
     */
    public void inputU() throws Exception{
        Main.inputU();
    }

    /**
     * ��Ӧ��Ļ���̰�ťI����
     *
     * @throws Exception �쳣
     */
    public void inputI() throws Exception{
        Main.inputI();
    }

    /**
     * ��Ӧ��Ļ���̰�ťO����
     *
     * @throws Exception �쳣
     */
    public void inputO() throws Exception{
        Main.inputO();
    }

    /**
     * ��Ӧ��Ļ���̰�ťP����
     *
     * @throws Exception �쳣
     */
    public void inputP() throws Exception{
        Main.inputP();
    }

    /**
     * ��Ӧ��Ļ���̰�ťA����
     *
     * @throws Exception �쳣
     */
    public void inputA() throws Exception{
        Main.inputA();
    }

    /**
     * ��Ӧ��Ļ���̰�ťS����
     *
     * @throws Exception �쳣
     */
    public void inputS() throws Exception{
        Main.inputS();
    }

    /**
     * ��Ӧ��Ļ���̰�ťD����
     *
     * @throws Exception �쳣
     */
    public void inputD() throws Exception{
        Main.inputD();
    }

    /**
     * ��Ӧ��Ļ���̰�ťF����
     *
     * @throws Exception �쳣
     */
    public void inputF() throws Exception{
        Main.inputF();
    }

    /**
     * ��Ӧ��Ļ���̰�ťG����
     *
     * @throws Exception �쳣
     */
    public void inputG() throws Exception{
        Main.inputG();
    }

    /**
     * ��Ӧ��Ļ���̰�ťH����
     *
     * @throws Exception �쳣
     */
    public void inputH() throws Exception{
        Main.inputH();
    }

    /**
     * ��Ӧ��Ļ���̰�ťJ����
     *
     * @throws Exception �쳣
     */
    public void inputJ() throws Exception{
        Main.inputJ();
    }

    /**
     * ��Ӧ��Ļ���̰�ťK����
     *
     * @throws Exception �쳣
     */
    public void inputK() throws Exception{
        Main.inputK();
    }

    /**
     * ��Ӧ��Ļ���̰�ťL����
     *
     * @throws Exception �쳣
     */
    public void inputL() throws Exception{
        Main.inputL();
    }

    /**
     * ��Ӧ��Ļ���̰�ťZ����
     *
     * @throws Exception �쳣
     */
    public void inputZ() throws Exception{
        Main.inputZ();
    }

    /**
     * ��Ӧ��Ļ���̰�ťX����
     *
     * @throws Exception �쳣
     */
    public void inputX() throws Exception{
        Main.inputX();
    }

    /**
     * ��Ӧ��Ļ���̰�ťC����
     *
     * @throws Exception �쳣
     */
    public void inputC() throws Exception{
        Main.inputC();
    }

    /**
     * ��Ӧ��Ļ���̰�ťV����
     *
     * @throws Exception �쳣
     */
    public void inputV() throws Exception{
        Main.inputV();
    }

    /**
     * ��Ӧ��Ļ���̰�ťB����
     *
     * @throws Exception �쳣
     */
    public void inputB() throws Exception{
        Main.inputB();
    }

    /**
     * ��Ӧ��Ļ���̰�ťN����
     *
     * @throws Exception �쳣
     */
    public void inputN() throws Exception{
        Main.inputN();
    }

    /**
     * ��Ӧ��Ļ���̰�ťM����
     *
     * @throws Exception �쳣
     */
    public void inputM() throws Exception{
        Main.inputM();
    }

    /**
     * �����˸�
     */
    public void backSpace() {
        Main.backSpace();
    }

    /**
     * ����AdvanceMode
     */
    public void advanceEnter() {
        Main.advanceEnter();
    }
}
