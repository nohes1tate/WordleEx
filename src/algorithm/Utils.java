/**
 * 工具类，记录一些算法函数
 *
 * @author 宋益康
 */
public class Utils {
    /**
     * sigmoid函数，用于赋予单词权重
     *
     * @param x x
     * @return 1/(1+e^(-x))
     */
    static double sigmoid(double x){
        return 1/(1+Math.exp(-x));
    }
}
