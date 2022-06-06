import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AniLetter {
    Text text;
    FadeTransition ft = new FadeTransition();
    AniLetter (String s){
        text = new Text(s);
        text.setFont(Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 100));
        text.setFill(Color.gray(0.9));
        ft.setNode(text);
        ft.setDuration(Duration.seconds(1));
        ft.setFromValue(0);
        ft.setToValue(1);
    }
}
