import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.util.Duration;

/**
 * 字符串动画
 * 该类用来播放字符串的动画，包含字符串内容和其渐变动画
 */
public class AniString {
    /**
     * 字符串
     */
    Text string;
    /**
     * 渐变动画
     */
    FadeTransition ft;
    /**
     * 渐变动画2
     */
    FadeTransition ft2;

    /**
     * 字符串的动画
     *
     * @param s 字符串
     * @param c 字符串的颜色
     */
    AniString(String s, Color c){
        string = new Text(s);
        string.setFont(Font.font("times new roman", FontWeight.MEDIUM, FontPosture.REGULAR, 25));
        string.setTextAlignment(TextAlignment.JUSTIFY);
        string.setFill(c);
        ft = new FadeTransition();
        ft.setNode(string);
        ft.setDuration(Duration.seconds(0.4));
        ft.setFromValue(0);
        ft.setToValue(1);
        ft2 = new FadeTransition();
        ft2.setNode(string);
        ft2.setDuration(Duration.seconds(0.4));
        ft2.setFromValue(1);
        ft2.setToValue(0);
        }
}
