import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 测试类
 *
 * @author 宋益康
 */
public class Test {
    /**
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        try {
            WordList.PossibleWord = WordList.ReadWord("src/Data/possible_words.txt");
            WordList.LegalWord = WordList.ReadWord("src/Data/allowed_words.txt");
            WordList.WordPrior = WordList.ReadPrior("src/Data/freq_map.json");
            ArrayList<String> list = new ArrayList<>(WordList.PossibleWord);
            int ansIdx = new Random().nextInt(list.size());
            String ans = list.get(ansIdx);
            int cnt = 0;
            boolean got = false;
            while (!got) {
                cnt++;
                GuessAlgorithm.getWordScore(WordList.LegalWord, WordList.PossibleWord);
                String guessWord = GuessAlgorithm.wsList.get(0).word;
                Word guess = new Word(guessWord);
                guess.CheckAns(ans);
                System.out.println("guess num: " + cnt + " guess word: " + guessWord);
                System.out.println("Color: " + guess.ShowColor());
                if (guess.getState() != 0) {
                    WordList.PossibleWord = GuessAlgorithm.updatePossibleWord(WordList.PossibleWord, guess.getState(), guessWord);
                } else {
                    got = true;
                    System.out.println("ans: " + ans + " guess: " + guessWord + " times: " + cnt);
                }
            }
            System.out.println("Finish");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
