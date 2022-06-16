import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * ani����
 * ���ζ���
 *
 * @author 86153
 * @date 2022/06/16
 */
public class AniRectangular {
    /**
     * ����
     */
    Rectangle rectangle;
    /**
     * Ӣ��������ʱ����
     */
    FadeTransition ft = new FadeTransition();
    /**
     * ���
     */
    double width;
    /**
     * �߶�
     */
    double height;

    /**
     * ani����
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
