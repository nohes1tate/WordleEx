import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * 矩形动画
 * 该类用来播放矩形的动画，包含矩形与其长宽和其渐变动画
 */
public class AniRectangular {
    /**
     * 矩形
     */
    Rectangle rectangle;
    /**
     * 渐变动画
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
     * 构造矩形动画
     *
     * @param w 矩形的宽
     * @param h 矩形的高
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
