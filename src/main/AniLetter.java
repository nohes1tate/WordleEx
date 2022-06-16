import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.util.Duration;

/**
 * 字母动画
 */
public class AniLetter {
    /**
     * 文本
     */
    Text text;
    /**
     * 渐变动画
     */
    FadeTransition ft = new FadeTransition();
    AniLetter (String s){
        text = new Text(s);
        text.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 50));
        text.setTextAlignment(TextAlignment.JUSTIFY);
        text.setFill(Color.gray(0.9));
        ft.setNode(text);
        ft.setDuration(Duration.seconds(1));
        ft.setFromValue(0);
        ft.setToValue(1);
    }
}
