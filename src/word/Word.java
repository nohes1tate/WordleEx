import java.util.ArrayList;

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
