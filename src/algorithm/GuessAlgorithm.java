import java.util.*;

public class GuessAlgorithm {
    /**
     * ÿ��������ֵļ�Ȩ����
     */
    static double[] chance = new double[3*3*3*3*3];

    /**
     * ���п��ܵ��ʵ�Ȩ�غ�
     */
    static double priorAll;

    /**
     * ����ÿ�����ʲ²�ķ���
     */
    static ArrayList<WordWithScore> wsList = new ArrayList<>();

    /**
     * ���¿��ܴ�
     *
     * @param preSet ��ǰ�Ŀ��ܴʼ���
     * @param state  ״̬
     * @param guess  �ϴβ²�Ĵ�
     * @return {@link Set}<{@link String}>
     * @throws Exception �쳣
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
     * ��ȡ���ʵķ���
     *
     * @param LegalWord    �Ϸ���
     * @param PossibleWord ��ǰ״̬�Ŀ���ֵ
     * @throws Exception �쳣
     */
    public static void getWordScore(Set<String> LegalWord, Set<String> PossibleWord) throws Exception{
        ArrayList<WordWithScore> tmpList = new ArrayList<>();
        //��һ��ѭ�����������кϷ��ĵ���
        for (String lWord : LegalWord) {
            boolean show = false;
            priorAll=0;
            Arrays.fill(chance, 0);
            Word tmpWord = new Word(lWord);

            //��������Ϊ�𰸵Ĵ�
            for (String pWord : PossibleWord) {
                tmpWord.CheckAns(pWord);
                int state;
                state = tmpWord.getState();
                chance[state] += WordList.WordPrior.get(pWord);
                if(show){
                    System.out.println("possible word:"+pWord+" result:" + tmpWord.ShowColor());
                }
            }
            //����ÿ��״̬�ĸ���֮��
            for (double c : chance) {
                priorAll += c;
            }
            for (int i = 0; i < chance.length; i++) {
                chance[i] /= priorAll;
            }
            //��ȡ���ʶ�Ӧ����Ϣ��
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
 * ���������Ӧ�÷�
 *
 * @author ���濵
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
