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
            WordList.AnswerWord = WordList.ReadWord("src/Data/possible_words.txt");
            WordList.PossibleWord = WordList.ReadWord("src/Data/allowed_words.txt");
            WordList.LegalWord = WordList.ReadWord("src/Data/allowed_words.txt");
            WordList.WordPrior = WordList.ReadPrior("src/Data/freq_map.json");
            ArrayList<String> list = new ArrayList<>(WordList.AnswerWord);
            int ansIdx = new Random().nextInt(list.size());
            String ans = list.get(ansIdx);
            int cnt = 0;
            boolean got = false;
            GuessAlgorithm.eNow = GuessAlgorithm.calENow(WordList.PossibleWord);
            while (!got) {
                cnt++;
                GuessAlgorithm.getShowList(WordList.PossibleWord);
                GuessAlgorithm.getWordScore(WordList.LegalWord, WordList.PossibleWord);
                String guessWord = GuessAlgorithm.wsList.get(0).word;
                GuessAlgorithm.getWordStatusInfo(guessWord,WordList.PossibleWord);
                Word guess = new Word(guessWord);
                guess.CheckAns(ans);
                System.out.println("guess num: " + cnt + " guess word: " + guessWord + " eNow: " + GuessAlgorithm.eNow + "bits");
                System.out.println("expected h:" + GuessAlgorithm.wsList.get(0).entropy);
                System.out.println("Color: " + guess.ShowColor());
                if (guess.getState() != 0) {
                    WordList.PossibleWord = GuessAlgorithm.updatePossibleWord(WordList.PossibleWord, guess.getState(), guessWord);
                    double newE = GuessAlgorithm.calENow(WordList.PossibleWord);
                    System.out.println("got info:"+(GuessAlgorithm.eNow - newE)+"bits\n");
                    GuessAlgorithm.eNow = newE ;
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
