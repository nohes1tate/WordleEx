/**
 * �����࣬��¼һЩ�㷨����
 *
 * @author ���濵
 */
public class Utils {
    /**
     * sigmoid���������ڸ��赥��Ȩ��
     *
     * @param x x
     * @return 1/(1+e^(-x))
     */
    static double sigmoid(double x){
        return 1/(1+Math.exp(-x));
    }
}
