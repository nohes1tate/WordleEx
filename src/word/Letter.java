/**
 * 输入的字母
 * Letter类是玩家操作的原子单位
 * @author 宋益康
 */
public class Letter {
    /**
     *  字母的颜色
     */
    public LetterColor letterColor;

    /**
     *  字母的内容
     */
    public char letterContent;

    /**
     *  字母的位置
     */
    public int  letterPos;

    /**
     * 字母的构造方法，创建一个Letter对象
     * 构造时默认字的颜色为黑色
     * @param content 字母内容
     * @param pos     字母在单词中位置
     */
    public Letter(char content, int pos) throws Exception{
        if(!(content>='a'&&content<='z')){
            throw new LetterIOException("Letter Input Error");
        }
        letterContent=content;
        letterPos=pos;
        letterColor=LetterColor.Black;

    }

    /**
     * 判断颜色
     * 根据正确答案和判定规则判定字母的颜色
     * @param ans 正确答案
     * @param pos 判定格的位置
     * @return boolean 是否能判定当前格的颜色
     * @see LetterColor 颜色判定规则
     */
    public boolean JudgeColor(String ans,int pos){
        if(ans.charAt(pos)==this.letterContent){
            if(pos==this.letterPos){
            ChangeColor(LetterColor.Green);
            }
            else {
                ChangeColor(LetterColor.Yellow);
            }
            return true;
        }
        return false;
    }

    public void ChangeColor(LetterColor letterColor1){
        this.letterColor=letterColor1;
    }
}

/**
 * LetterIOException
 * 字母输入异常报错
 * @author 宋益康
 * @date 2022/05/22
 */
class LetterIOException extends Exception{
    String message;
    public LetterIOException(String ErrMessage){
        message=ErrMessage;
    }

    @Override
    public String toString(){
        return message;
    }
}
