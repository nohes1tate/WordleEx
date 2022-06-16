import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * ani矩形
 * 矩形动画
 *
 * @author 86153
 * @date 2022/06/16
 */
public class AniRectangular {
    /**
     * 矩形
     */
    Rectangle rectangle;
    /**
     * 英国《金融时报》
     */
    FadeTransition ft = new FadeTransition();
    /**
     * 宽度
     */
    double width;
    /**
     * 高度
     */
    double height;

    /**
     * ani矩形
     *
     * @param w w
     * @param h h
     */
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
