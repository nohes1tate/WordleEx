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
     * 返回按钮图像
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
     * 屏幕键盘按钮A
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
     * 屏幕键盘按钮Enter
     */
    @FXML
    private Button ButtonENTER;

    /**
     * 屏幕键盘按钮Backspace
     */
    @FXML
    private Button ButtonBackspace;

    /**
     * 当鼠标在返回按钮上时改变鼠标指针且按钮变色
     */
    public void mouseOnBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        backImg.setImage(new Image("arrow1.png"));
    }

    /**
     * 当鼠标离开按钮时改变鼠标指针且按钮变色
     */
    public void mouseLeaveBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
        backImg.setImage(new Image("arrow.png"));
    }

    /**
     * 回到菜单页面
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
     * 处理改变按钮颜色
     *
     * @param key     关键
     * @param color   颜色
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
     * 改变某个按钮颜色
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
     * 响应屏幕键盘按钮Q输入
     *
     * @throws Exception 异常
     */
    public void inputQ() throws Exception{
        Main.inputQ();
    }

    /**
     * 响应屏幕键盘按钮W输入
     *
     * @throws Exception 异常
     */
    public void inputW() throws Exception{
        Main.inputW();
    }

    /**
     * 响应屏幕键盘按钮E输入
     *
     * @throws Exception 异常
     */
    public void inputE() throws Exception{
        Main.inputE();
    }

    /**
     * 响应屏幕键盘按钮R输入
     *
     * @throws Exception 异常
     */
    public void inputR() throws Exception{
        Main.inputR();
    }

    /**
     * 响应屏幕键盘按钮T输入
     *
     * @throws Exception 异常
     */
    public void inputT() throws Exception{
        Main.inputT();
    }

    /**
     * 响应屏幕键盘按钮Y输入
     *
     * @throws Exception 异常
     */
    public void inputY() throws Exception{
        Main.inputY();
    }

    /**
     * 响应屏幕键盘按钮U输入
     *
     * @throws Exception 异常
     */
    public void inputU() throws Exception{
        Main.inputU();
    }

    /**
     * 响应屏幕键盘按钮I输入
     *
     * @throws Exception 异常
     */
    public void inputI() throws Exception{
        Main.inputI();
    }

    /**
     * 响应屏幕键盘按钮O输入
     *
     * @throws Exception 异常
     */
    public void inputO() throws Exception{
        Main.inputO();
    }

    /**
     * 响应屏幕键盘按钮P输入
     *
     * @throws Exception 异常
     */
    public void inputP() throws Exception{
        Main.inputP();
    }

    /**
     * 响应屏幕键盘按钮A输入
     *
     * @throws Exception 异常
     */
    public void inputA() throws Exception{
        Main.inputA();
    }

    /**
     * 响应屏幕键盘按钮S输入
     *
     * @throws Exception 异常
     */
    public void inputS() throws Exception{
        Main.inputS();
    }

    /**
     * 响应屏幕键盘按钮D输入
     *
     * @throws Exception 异常
     */
    public void inputD() throws Exception{
        Main.inputD();
    }

    /**
     * 响应屏幕键盘按钮F输入
     *
     * @throws Exception 异常
     */
    public void inputF() throws Exception{
        Main.inputF();
    }

    /**
     * 响应屏幕键盘按钮G输入
     *
     * @throws Exception 异常
     */
    public void inputG() throws Exception{
        Main.inputG();
    }

    /**
     * 响应屏幕键盘按钮H输入
     *
     * @throws Exception 异常
     */
    public void inputH() throws Exception{
        Main.inputH();
    }

    /**
     * 响应屏幕键盘按钮J输入
     *
     * @throws Exception 异常
     */
    public void inputJ() throws Exception{
        Main.inputJ();
    }

    /**
     * 响应屏幕键盘按钮K输入
     *
     * @throws Exception 异常
     */
    public void inputK() throws Exception{
        Main.inputK();
    }

    /**
     * 响应屏幕键盘按钮L输入
     *
     * @throws Exception 异常
     */
    public void inputL() throws Exception{
        Main.inputL();
    }

    /**
     * 响应屏幕键盘按钮Z输入
     *
     * @throws Exception 异常
     */
    public void inputZ() throws Exception{
        Main.inputZ();
    }

    /**
     * 响应屏幕键盘按钮X输入
     *
     * @throws Exception 异常
     */
    public void inputX() throws Exception{
        Main.inputX();
    }

    /**
     * 响应屏幕键盘按钮C输入
     *
     * @throws Exception 异常
     */
    public void inputC() throws Exception{
        Main.inputC();
    }

    /**
     * 响应屏幕键盘按钮V输入
     *
     * @throws Exception 异常
     */
    public void inputV() throws Exception{
        Main.inputV();
    }

    /**
     * 响应屏幕键盘按钮B输入
     *
     * @throws Exception 异常
     */
    public void inputB() throws Exception{
        Main.inputB();
    }

    /**
     * 响应屏幕键盘按钮N输入
     *
     * @throws Exception 异常
     */
    public void inputN() throws Exception{
        Main.inputN();
    }

    /**
     * 响应屏幕键盘按钮M输入
     *
     * @throws Exception 异常
     */
    public void inputM() throws Exception{
        Main.inputM();
    }

    /**
     * 处理退格
     */
    public void backSpace() {
        Main.backSpace();
    }

    /**
     * 进入AdvanceMode
     */
    public void advanceEnter() {
        Main.advanceEnter();
    }
}
