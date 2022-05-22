import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * �����б�
 * �����Ϸ������뵥�ʺͿ��Գ�Ϊ�𰸵ĵ���
 *
 * @author ���濵
 */
public class WordList {
    /**
     * ����Ҫһ��WordList�����õ���ģʽ����
     */
    private static WordList singalton;

    /**
     * ������ʵ��
     */
    private WordList(){}

    /**
     * �Ϸ������뵥��
     */
    static Set<String> LegalWord = new HashSet<>();

    /**
     * ����Ϊ�𰸵ĵ���
     */
    static Set<String> PossibleWord = new HashSet<>();

    /**
     * ������
     * ���ļ��л�ȡ����
     *
     * @param fileName �����ļ�������
     * @return {@link Set}<{@link String}>
     * @throws IOException �׳�IO�쳣
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
