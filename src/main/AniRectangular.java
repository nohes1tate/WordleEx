import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * ¾ØÐÎ¶¯»­
 *
 * @author ÍõÌíÒÝ
 * @date 2022/06/16
 */
public class AniRectangular {
    Rectangle rectangle;
    FadeTransition ft = new FadeTransition();
    double width;
    double height;
    AniRectangular(double w, double h){
        width = w;
        height = h;
        rectangle = new Rectangle(w, h);
        rectangle.setFill(Color.SKYBLUE);
        ft.setNode(rectangle);
        ft.setDuration(Duration.seconds(1));
        ft.setFromValue(0);
        ft.setToValue(1);
    }
}
