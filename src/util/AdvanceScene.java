import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class AdvanceScene {
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

    /**
     * 当鼠标进入按钮区域改变鼠标样式的方法。
     */
    public void mouseOnButton(){
        // Main.getMainMenuScene().setCursor(Cursor.HAND);
        Main.getMainWindow().getScene().setCursor(Cursor.HAND);
    }
    /**
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveButton(){
        // Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
        Main.getMainWindow().getScene().setCursor(Cursor.DEFAULT);
    }

    public void testMethod(){
        System.out.println("testMethod");
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

    public void changeButtonQColor() throws Exception{
        BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
        Background background = new Background(background_fill);
        ButtonQ.setBackground(background);
    }

    public void changeButtonWColor() throws Exception{
        BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
        Background background = new Background(background_fill);
        ButtonW.setBackground(background);
    }

    public void changeButtonColor(char key,int color) throws Exception{
        System.out.print(key);
        System.out.println("printkey");
        if(key=='q')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonQ.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonQ.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonQ.setBackground(background);
            }
        }
        else if(key=='w')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonW.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonW.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonW.setBackground(background);
            }
        }
        else if(key=='e')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonE.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonE.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonE.setBackground(background);
            }
        }
        else if(key=='r')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonR.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonR.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonR.setBackground(background);
            }
        }
        else if(key=='t')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonT.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonT.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonT.setBackground(background);
            }
        }
        else if(key=='y')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonY.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonY.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonY.setBackground(background);
            }
        }
        else if(key=='u')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonU.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonU.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonU.setBackground(background);
            }
        }
        else if(key=='i')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonI.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonI.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonI.setBackground(background);
            }
        }
        else if(key=='o')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonO.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonO.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonO.setBackground(background);
            }
        }
        else if(key=='p')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonP.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonP.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonP.setBackground(background);
            }
        }
        else if(key=='a')
        {
            System.out.println("changecolor");
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonA.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonA.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonA.setBackground(background);
            }
        }
        else if(key=='s')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonS.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonS.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonS.setBackground(background);
            }
        }
        else if(key=='d')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonD.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonD.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonD.setBackground(background);
            }
        }
        else if(key=='f')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonF.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonF.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonF.setBackground(background);
            }
        }
        else if(key=='g')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonG.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonG.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonG.setBackground(background);
            }
        }
        else if(key=='h')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonH.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonH.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonH.setBackground(background);
            }
        }
        else if(key=='j')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonJ.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonJ.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonJ.setBackground(background);
            }
        }
        else if(key=='k')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonK.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonK.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonK.setBackground(background);
            }
        }
        else if(key=='l')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonL.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonL.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonL.setBackground(background);
            }
        }
        else if(key=='z')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonZ.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonZ.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonZ.setBackground(background);
            }
        }
        else if(key=='x')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonX.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonX.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonX.setBackground(background);
            }
        }
        else if(key=='c')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonC.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonC.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonC.setBackground(background);
            }
        }
        else if(key=='v')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonV.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonV.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonV.setBackground(background);
            }
        }
        else if(key=='b')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonB.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonB.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonB.setBackground(background);
            }
        }
        else if(key=='n')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonN.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonN.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonN.setBackground(background);
            }
        }
        else if(key=='m')
        {
            if(color==1)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#808080"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonM.setBackground(background);
            }
            else if(color==2)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#FFFF00"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonM.setBackground(background);
            }
            else if(color==3)
            {
                BackgroundFill background_fill = new BackgroundFill(Paint.valueOf("#008000"),new CornerRadii(1),new Insets(1));
                Background background = new Background(background_fill);
                ButtonM.setBackground(background);
            }
        }
        System.out.println("printkeydone");
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
    public void backSpace() throws Exception{
        Main.backSpace();
    }
    public void advanceEnter() throws Exception{
        Main.advanceEnter();
    }
}
