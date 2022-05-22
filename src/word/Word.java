import java.util.ArrayList;

/**
 * ����
 * ��ĸ�Ե���Ϊ��λ����������ж�
 * @author ���濵
 */
public class Word {
    /**
     * һ�����ʰ�������ĸ
     */
    public ArrayList<Letter> letters = new ArrayList<>();

    /**
     * ��ǰ��������
     */
    StringBuilder WordContent = new StringBuilder();

    /**
     * �򵥴��������ĸ
     * �������ж�������ĸ���Ƿ�����
     * @param c c
     * @throws Exception �׳����������쳣
     */
    public void AddLetter(char c) throws Exception {
        if(letters.size()<5){
        letters.add(new Letter(c, letters.size()));
        WordContent.append(c);
        }
    }

    /**
     * ɾ�����һ����ĸ
     */
    public void RemoveLetter() {
        if(letters.size()>0){
            int idx = letters.size() -1;
            letters.remove(idx);
            WordContent.deleteCharAt(idx);
        }
    }

    /**
     * �������𰸲�����ĸ��ɫ
     * ��ĸ��ɫ�����LetterColor
     * ��ǰ��ĸ������5��ʱ�׳���ĸ�������쳣
     * ��ǰ���ʲ��ڿ��ܵĵ�����ʱ�׳����Ϸ������쳣
     * @param ans ��ȷ��
     * @see LetterColor
     * @throws Exception ���ܵ��쳣
     */
    public void CheckAns(String ans) throws Exception{
        if(letters.size()<5){
            throw new WordSizeException("Not enough letters");
        }
        else {
            String wordContent = this.WordContent.toString();
            if(!WordList.LegalWord.contains(wordContent)){
                throw new WordIllegalException("Not in the word list");
            }
            else {
                int i, j;
                boolean[] PosIsJudge = new boolean[5];
                for (i = 0; i < 5; i++){
                    PosIsJudge[i]=letters.get(i).JudgeColor(ans, i);
                }
                for (i = 0; i < 5; i++){
                    if(letters.get(i).letterColor==LetterColor.Black){
                        for(j=0;j<5;j++){
                            if(j!=i&&!PosIsJudge[j]){
                                PosIsJudge[j]=letters.get(i).JudgeColor(ans, j);
                            }
                        }
                    }
                }
                for (i = 0; i < 5; i++){
                    if(letters.get(i).letterColor==LetterColor.Black){
                        letters.get(i).letterColor=LetterColor.Grey;
                    }
                }
            }
        }
    }
}

/**
 * ������Ŀ�쳣
 * @author ���濵
 */
class WordSizeException extends Exception{
    String message;
    public WordSizeException(String ErrMessage){
        message=ErrMessage;
    }

    @Override
    public String toString(){
        return message;
    }
}

/**
 * ���ʲ��Ϲ��쳣
 * @author ���濵
 */
class WordIllegalException extends Exception{
    String message;
    public WordIllegalException(String ErrMessage){
        message=ErrMessage;
    }

    @Override
    public String toString(){
        return message;
    }
}
