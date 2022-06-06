import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * �����б�
 * �����Ϸ����뵥�ʺͿ��Գ�Ϊ�𰸵ĵ���
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
     * �Ϸ����뵥��
     */
    static Set<String> LegalWord = new HashSet<>();

    /**
     * ����Ϊ�𰸵ĵ���
     */
    static Set<String> PossibleWord = new HashSet<>();

    /**
     * ����Ȩ��
     */
    static HashMap<String,Double> WordPrior = new HashMap<>();

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

    /**
     * ���뵥�ʶ�Ӧ�Ĵ�Ƶ
     *
     * @param fileName �ļ�����
     * @return {@link HashMap}<{@link String}, {@link Double}>
     * @throws IOException �׳�IO�쳣
     */
    public static HashMap<String,Double> ReadPrior(String fileName) throws IOException {
        HashMap<String,Double> PriorMap = new HashMap<>();
        ArrayList<WordWithFreq> wfList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String freqFile;
        freqFile = br.readLine();
        String[] nani = freqFile.split(",");
        for(String str:nani){
            str = str.replace("\"","");
            str = str.replace("{","");
            str = str.replace("}","");
            str = str.replace(" ","");
            String[] WandF = str.split(":");
            String word = WandF[0];
            double freq = Double.parseDouble(WandF[1]);
            wfList.add(new WordWithFreq(word,freq));
        }
        Collections.sort(wfList);
        for(int i=0;i< wfList.size();i++){
            int nCommon = 3000;
            int sigmoidWidth = 10;
            double x;
            double prior;
            x=sigmoidWidth*(-0.5+((double)i -(double) nCommon)/(double) wfList.size());
            WordWithFreq wf =wfList.get(i);
            prior=Utils.sigmoid(x);
            PriorMap.put(wf.word,prior);
        }
        return PriorMap;
    }
}

/**
 * ���浥�ʼ���Ƶ��
 *
 * @author ���濵
 */
class WordWithFreq implements Comparable<WordWithFreq>{
    String word;
    double freq;
    WordWithFreq(String w,double f){
        word=w;
        freq=f;
    }

    @Override
    public int compareTo(WordWithFreq w){
        if(this.freq>w.freq)
            return 1;
        else if(this.freq== w.freq)
            return 0;
        return -1;
    }
}