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

public class AdvanceScene {

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

    public void mouseOnBackButton(){
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
        backImg.setImage(new Image("arrow1.png"));
    }
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

    public void changeButtonColor(char key,int color) {
        changeButtonColor(key, color, ButtonQ, ButtonW, ButtonE, ButtonR, ButtonT, ButtonY, ButtonU, ButtonI, ButtonO, ButtonP, ButtonA, ButtonS, ButtonD, ButtonF, ButtonG, ButtonH, ButtonJ, ButtonK, ButtonL, ButtonZ, ButtonX, ButtonC, ButtonV, ButtonB, ButtonN, ButtonM);
    }

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
    public void advanceEnter() {
        Main.advanceEnter();
    }
}
