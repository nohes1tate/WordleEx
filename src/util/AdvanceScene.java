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
 * 前场景
 *
 * @author 86153
 * @date 2022/06/16
 */
public class AdvanceScene {

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
        changeButtonColor(key, color, ButtonQ, ButtonW, ButtonE, ButtonR, ButtonT, ButtonY, ButtonU, ButtonI, ButtonO, ButtonP, ButtonA, ButtonS, ButtonD, ButtonF, ButtonG, ButtonH, ButtonJ, ButtonK, ButtonL, ButtonZ, ButtonX, ButtonC, ButtonV, ButtonB, ButtonN, ButtonM);
    }

    /**
     * 改变按钮颜色
     *
     * @param key     关键
     * @param color   颜色
     * @param buttonQ buttonq
     * @param buttonW buttonw
     * @param buttonE buttone
     * @param buttonR buttonr
     * @param buttonT buttont
     * @param buttonY 钮扣状
     * @param buttonU buttonu
     * @param buttonI buttoni
     * @param buttonO buttono
     * @param buttonP buttonp
     * @param buttonA buttona
     * @param buttonS 按钮
     * @param buttonD buttond
     * @param buttonF buttonf
     * @param buttonG buttong
     * @param buttonH buttonh
     * @param buttonJ buttonj
     * @param buttonK buttonk
     * @param buttonL buttonl
     * @param buttonZ buttonz
     * @param buttonX buttonx
     * @param buttonC buttonc
     * @param buttonV buttonv
     * @param buttonB buttonb
     * @param buttonN buttonn
     * @param buttonM buttonm
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
     * 按钮颜色
     *
     * @param color  颜色
     * @param button 按钮
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
     * 提前进入
     */
    public void advanceEnter() {
        Main.advanceEnter();
    }
}
