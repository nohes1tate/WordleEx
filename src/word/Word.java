import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

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
     * Word��Ĺ��췽��
     *
     * @param word ����ĵ���
     * @throws Exception �쳣
     */
    public Word(String word) throws Exception{
        for(int i=0;i<word.length();i++){
            this.AddLetter(word.charAt(i));
        }
    }
    public Word(){}
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
     * ��ȡ���ʵ�ǰ״̬����3���Ƽ�������ɫ����ɫ����ɫ�ֱ��Ӧ�����Ƶ�0��1��2����ɫ�����쳣ֵ-1
     *
     * @return int ״̬��Ӧ����
     * @throws Exception ���ܵ��쳣
     */
    public int getState() throws Exception{
        int res=0;
        for (Letter l:letters){
            res*=3;
            if(l.letterColor.equals(LetterColor.Black)){
                throw new WordColorException("Found Black Letter in word "+WordContent);
            }
            else if(l.letterColor.equals(LetterColor.Green)){
                res+=0;
            }
            else if(l.letterColor.equals(LetterColor.Yellow)){
                res+=1;
            }
            else if(l.letterColor.equals(LetterColor.Grey)){
                res+=2;
            }
        }
        return res;
    }

    public String ShowColor() {
        StringBuilder sb = new StringBuilder();
        for (Letter l:letters){
            if(l.letterColor.equals(LetterColor.Green)){
                sb.append("Green ");
            }
            else if(l.letterColor.equals(LetterColor.Yellow)){
                sb.append("Yellow ");
            }
            else if(l.letterColor.equals(LetterColor.Grey)){
                sb.append("Grey ");
            }
        }
        return sb.toString();
    }

    public static boolean CheckInList(String content) {
        return WordList.LegalWord.contains(content);
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
            if(!CheckInList(wordContent)){
                throw new WordIllegalException("Not in the word list");
            }
            else {
                int i, j;
                boolean[] PosIsJudge = new boolean[5];
                Arrays.fill(PosIsJudge, false);
                for (i = 0; i < 5; i++){
                    PosIsJudge[i]=letters.get(i).JudgeColor(ans, i);
                }
                for (i = 0; i < 5; i++){
                    if(!PosIsJudge[i]){
                        for(j=0;j<5;j++){
                            if(j!=i&&!PosIsJudge[i]){
                                PosIsJudge[i]=letters.get(i).JudgeColor(ans, j);
                            }
                        }
                    }
                }
                for (i = 0; i < 5; i++){
                    if(!PosIsJudge[i]){
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

class WordColorException extends Exception{
    String message;
    public WordColorException(String ErrMessage) { message=ErrMessage; }

    @Override
    public String toString() { return message; }
}
