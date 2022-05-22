import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 单词列表
 * 包含合法的输入单词和可以成为答案的单词
 *
 * @author 宋益康
 */
public class WordList {
    /**
     * 仅需要一个WordList，采用单例模式构造
     */
    private static WordList singalton;

    /**
     * 单例的实现
     */
    private WordList(){}

    /**
     * 合法的输入单词
     */
    static Set<String> LegalWord = new HashSet<>();

    /**
     * 可能为答案的单词
     */
    static Set<String> PossibleWord = new HashSet<>();

    /**
     * 读单词
     * 从文件中获取单词
     *
     * @param fileName 输入文件的名字
     * @return {@link Set}<{@link String}>
     * @throws IOException 抛出IO异常
     */
    public static Set<String> ReadWord(String fileName) throws IOException {
        Set<String> WordSet = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String word;
        while ((word = br.readLine()) != null) {
            WordSet.add(word);
        }
        br.close();
        return WordSet;
    }
}
