import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 单词列表
 * 包含合法输入单词和可以成为答案的单词
 */
public class WordList {

    /**
     * 阻止WordList的构造
     */
    private WordList(){}

    /**
     * 合法输入单词
     */
    static Set<String> LegalWord = new HashSet<>();

    /**
     * 答案词库
     */
    static Set<String> AnswerWord = new HashSet<>();

    /**
     * 可能为答案的单词
     */
    static Set<String> PossibleWord = new HashSet<>();

    /**
     * 单词权重
     */
    static HashMap<String,Double> WordPrior = new HashMap<>();

    /**
     * 读单词
     * 从文件中获取单词
     *
     * @param fileName 输入文件的名字
     * @return String集合
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

    /**
     * 读入单词对应的词频
     *
     * @param fileName 文件名称
     * @return 单词与其词频对应的HashMap
     * @throws IOException 抛出IO异常
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
 * 保存单词及其频率
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

/**
 * 保存单词与它的概率
 */
class WordWithChance {
    String word;
    double chance;
    double fill;
    WordWithChance(String w, double c, double f){
        word=w;
        chance=c;
        fill=f;
    }
}
