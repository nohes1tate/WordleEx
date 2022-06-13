/**
 * 字母颜色
 * Letter的颜色
 * 黑色(Black)表示字母被填入表格且没有被判定
 * 绿色(Green)表示字母在答案中出现且位置与答案中一致
 * 黄色(Yellow)表示字母出现在答案中但位置并不一致
 * 灰色(Grey)表示字母未出现在答案中
 * 特别的，字母颜色判定时会优先判定正确的字母位置
 * 对于不在正确位置的字母，从左往右依次判定，对于数目多出答案的字母会标记为灰色
 * 如：谜底为equal，猜测为speed，此时第一个E会被标记为黄色，第二个会被标记为灰色
 *
 * @author 宋益康
 */
public enum LetterColor {
    Black, Green, Grey, Yellow

}
