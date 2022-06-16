import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * ���ζ���
 * �����������ž��εĶ����������������䳤����佥�䶯��
 */
public class AniRectangular {
    /**
     * ����
     */
    Rectangle rectangle;
    /**
     * ���䶯��
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
     * ������ζ���
     *
     * @param w ���εĿ�
     * @param h ���εĸ�
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
