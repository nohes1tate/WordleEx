/**
 * �������ĸ
 * Letter������Ҳ�����ԭ�ӵ�λ
 * @author ���濵
 */
public class Letter {
    /**
     *  ��ĸ����ɫ
     */
    public LetterColor letterColor;

    /**
     *  ��ĸ������
     */
    public char letterContent;

    /**
     *  ��ĸ��λ��
     */
    public int  letterPos;

    /**
     * ��ĸ�Ĺ��췽��������һ��Letter����
     * ����ʱĬ���ֵ���ɫΪ��ɫ
     * @param content ��ĸ����
     * @param pos     ��ĸ�ڵ�����λ��
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
     * �ж���ɫ
     * ������ȷ�𰸺��ж������ж���ĸ����ɫ
     * @param ans ��ȷ��
     * @param pos �ж����λ��
     * @return boolean �Ƿ����ж���ǰ�����ɫ
     * @see LetterColor ��ɫ�ж�����
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
 * ��ĸ�����쳣����
 * @author ���濵
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
