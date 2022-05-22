import java.util.ArrayList;
import java.util.Random;

/**
 * ������
 *
 * @author ���濵
 */
public class Test {
    /**
     *
     *
     * @param args �����в���
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
