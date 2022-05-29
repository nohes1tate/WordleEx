import java.util.*;

public class GuessAlgorithm {
    /**
     * 每种情况出现的加权概率
     */
    static double[] chance = new double[3*3*3*3*3];

    /**
     * 所有可能单词的权重和
     */
    static double priorAll;

    /**
     * 评价每个单词猜测的分数
     */
    static ArrayList<WordWithScore> wsList = new ArrayList<>();

    /**
     * 更新可能词
     *
     * @param preSet 先前的可能词集合
     * @param state  状态
     * @param guess  上次猜测的词
     * @return {@link Set}<{@link String}>
     * @throws Exception 异常
     */
    public static Set<String> updatePossibleWord (Set<String> preSet,int state,String guess) throws Exception{
        Set<String> res = new HashSet<>();
        Word GuessWord = new Word(guess);
        for (String w : preSet){
            GuessWord.CheckAns(w);
            if(state==GuessWord.getState()){
                res.add(w);
            }
        }
        return res;
    }

    /**
     * 获取单词的分数
     *
     * @param LegalWord    合法词
     * @param PossibleWord 当前状态的可能值
     * @throws Exception 异常
     */
    public static void getWordScore(Set<String> LegalWord, Set<String> PossibleWord) throws Exception{
        ArrayList<WordWithScore> tmpList = new ArrayList<>();
        //第一层循环，遍历所有合法的单词
        for (String lWord : LegalWord) {
            boolean show = false;
            priorAll=0;
            Arrays.fill(chance, 0);
            Word tmpWord = new Word(lWord);

            //遍历可能为答案的词
            for (String pWord : PossibleWord) {
                tmpWord.CheckAns(pWord);
                int state;
                state = tmpWord.getState();
                chance[state] += WordList.WordPrior.get(pWord);
                if(show){
                    System.out.println("possible word:"+pWord+" result:" + tmpWord.ShowColor());
                }
            }
            //计算每种状态的概率之和
            for (double c : chance) {
                priorAll += c;
            }
            for (int i = 0; i < chance.length; i++) {
                chance[i] /= priorAll;
            }
            //获取单词对应的信息熵
                double p;
                double h = 0;
                double c;
            for (double v : chance) {
                p = v;
                if (p != 0)
                    h += p * Math.log(1 / p) / Math.log(2);
            }
                c=chance[0];
                tmpList.add(new WordWithScore(lWord, h + c, h, c));
        }
        tmpList.sort(Collections.reverseOrder());
        wsList=tmpList;
    }
}


/**
 * 单词与其对应得分
 *
 * @author 宋益康
 */
class WordWithScore implements Comparable<WordWithScore>{
        String word;
        double score;
        double possible;
        double entropy;
        WordWithScore(String w, double s, double h, double p){
        word=w;
        score=s;
        entropy=h;
        possible=p;
        }

@Override
public int compareTo(WordWithScore w){
        if(this.score>w.score)
        return 1;
        else if(this.score == w.score)
        return 0;
        return -1;
        }
        }
