import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.util.Duration;

public class AniString {
    Text string;
    FadeTransition ft;
    AniString(String s, Color c){
        string = new Text(s);
        string.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 25));
        string.setTextAlignment(TextAlignment.JUSTIFY);
        string.setFill(c);
        ft = new FadeTransition();
        ft.setNode(string);
        ft.setDuration(Duration.seconds(0.3));
        ft.setFromValue(0);
        ft.setToValue(1);
        }
}
