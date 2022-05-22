import java.util.ArrayList;
import java.util.Random;

/**
 * 测试类
 *
 * @author 宋益康
 */
public class Test {
    /**
     *
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        try{
            WordList.PossibleWord= WordList.ReadWord("src/Data/possible_words.txt");
            WordList.LegalWord= WordList.ReadWord("src/Data/allowed_words.txt");
            ArrayList<String> list = new ArrayList<>(WordList.PossibleWord);
            int ansIdx = new Random().nextInt(list.size());
            String ans = list.get(ansIdx);
            Word testWord = new Word();
            testWord.AddLetter('s');
            testWord.AddLetter('p');
            testWord.AddLetter('e');
            testWord.AddLetter('e');
            testWord.AddLetter('d');
            testWord.RemoveLetter();
            testWord.CheckAns(ans);
            System.out.println("Finish");}
        catch (Exception e){
            System.out.println(e);
        }
    }
}
