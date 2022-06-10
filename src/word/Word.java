import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 单词
 * 字母以单词为单位进行输入和判断
 * @author 宋益康
 */
public class Word {
    /**
     * 一个单词包含的字母
     */
    public ArrayList<Letter> letters = new ArrayList<>();

    /**
     * 当前单词内容
     */
    StringBuilder WordContent = new StringBuilder();

    /**
     * Word类的构造方法
     *
     * @param word 输入的单词
     * @throws Exception 异常
     */
    public Word(String word) throws Exception{
        for(int i=0;i<word.length();i++){
            this.AddLetter(word.charAt(i));
        }
    }
    public Word(){}
    /**
     * 向单词中添加字母
     * 方法会判定单词字母数是否已满
     * @param c c
     * @throws Exception 抛出单词输入异常
     */
    public void AddLetter(char c) throws Exception {
        if(letters.size()<5){
        letters.add(new Letter(c, letters.size()));
        WordContent.append(c);
        }
    }

    /**
     * 删除最后一个字母
     */
    public void RemoveLetter() {
        if(letters.size()>0){
            int idx = letters.size() -1;
            letters.remove(idx);
            WordContent.deleteCharAt(idx);
        }
    }

    /**
     * 获取单词当前状态，以3进制计数，绿色、黄色、灰色分别对应三进制的0、1、2，黑色返回异常值-1
     *
     * @return int 状态对应的数
     * @throws Exception 可能的异常
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
     * 检查输入答案并对字母着色
     * 字母着色规则见LetterColor
     * 当前字母数不足5个时抛出字母数不足异常
     * 当前单词不在可能的单词中时抛出不合法单词异常
     * @param ans 正确答案
     * @see LetterColor
     * @throws Exception 可能的异常
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
 * 单词数目异常
 * @author 宋益康
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
 * 单词不合规异常
 * @author 宋益康
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
