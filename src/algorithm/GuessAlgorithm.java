import java.io.File;
import java.io.PrintStream;
import java.util.*;

/**
 * �´��㷨
 */
public class GuessAlgorithm {

    /**
     * ��¼�Ƿ�Ϊ��һ�μ��㣬�������뱾���ļ�
     */
    static boolean isFirst = true;

    /**
     * ������ɫ״̬�Ŀ��ӻ���Ϣ
     */
    static ArrayList<StatusInfo> StateInfoList;

    /**
     * ���浱ǰʣ��Ŀ��ܵĵ��ʵļ���
     */
    static ArrayList<WordWithChance> PossibleWordChance;

    /**
     * ÿ��������ֵļ�Ȩ����
     */
    static double[] chance = new double[3*3*3*3*3];

    /**
     * ÿ��������ֵĴ���
     */
    static int[] times = new int[3*3*3*3*3];

    /**
     * ���п��ܵ��ʵ�Ȩ�غ�
     */
    static double priorAll;

    /**
     * ���е�������
     */
    static double eNow;

    /**
     * ���ܵ��ʵ�����
     */
    static int possibilities;

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
     * @return String����
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
        if(isFirst){
            wsList.clear();
            isFirst=false;
            String word;
            double score;
            double possibility;
            double entropy;
            File file = new File("src/Data/GuessWord.txt");
            // ���뵥��
            Scanner in = new Scanner(file);
            while (in.hasNext()){
                word = in.next();
                score = in.nextDouble();
                possibility = in.nextDouble();
                entropy = in.nextDouble();
                wsList.add(new WordWithScore(word,score,entropy,possibility));
                }
            return;
        }
        ArrayList<WordWithScore> tmpList = new ArrayList<>();
        //��һ��ѭ�����������кϷ��ĵ���
        for (String lWord : LegalWord) {
            priorAll=0;
            Arrays.fill(chance, 0);
            Arrays.fill(times, 0);
            Word tmpWord = new Word(lWord);

            //��������Ϊ�𰸵Ĵ�
            for (String pWord : PossibleWord) {
                tmpWord.CheckAns(pWord);
                int state;
                state = tmpWord.getState();
                chance[state] += WordList.WordPrior.get(pWord);
                times[state]++;
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

    /**
     * �����µ���
     *
     * @param PossibleWord ��ǰ���ܵĵ���
     * @return double
     */
    public static double calENow (Set<String> PossibleWord) {
        double pAll=0,res=0;
        for (String pWord : PossibleWord){
            pAll += WordList.WordPrior.get(pWord);
        }
        for (String pWord : PossibleWord){
            double p = WordList.WordPrior.get(pWord);
            p /= pAll;
            res += p * Math.log(1/p) / Math.log(2);
        }
        return res;
    }

    /**
     * �����ʾ�б���ȡÿһ�������Ǵ𰸵Ĵʳ�Ϊ�𰸵ĸ���
     * ��ȡ��չʾ�б�����PossibleWordChance��
     *
     * @param PossibleWord �����Ǵ𰸵Ĵ�
     */
    public static void getShowList (Set<String> PossibleWord) {
        String[] PossibleWordList =PossibleWord.toArray(new String[0]);
        ArrayList<WordWithChance> tmpPossibleWordChance = new ArrayList<>();
        Arrays.sort(PossibleWordList);
        double maxChance = 0;
        double pAll = 0;
        for (String pWord : PossibleWordList){
            pAll += WordList.WordPrior.get(pWord);
        }
        for (String pWord : PossibleWordList) {
            double c;
            c = WordList.WordPrior.get(pWord) / pAll;
            if(c>maxChance){
                maxChance=c;
            }
        }
        for (String pWord : PossibleWordList) {
            double c;
            double f;
            c = WordList.WordPrior.get(pWord) / pAll;
            f = c / maxChance;
            tmpPossibleWordChance.add(new WordWithChance(pWord, c, f));
        }
        PossibleWordChance = tmpPossibleWordChance;
        System.out.println("got show list");
    }

    /**
     * �õ���ǰ״̬����ɫ
     *
     * @param status ״̬
     * @return {@link LetterColor[]}
     */
    public static LetterColor[] getStatusColor(int status){
        LetterColor[] res = new LetterColor[5];
        for (int i=0; i<5; i++){
            int num;
            num = status%3;
            status/=3;
            LetterColor tmpColor = switch (num) {
                case 0 -> LetterColor.Green;
                case 1 -> LetterColor.Yellow;
                case 2 -> LetterColor.Grey;
                default -> LetterColor.Black;
            };
            res[4-i] = tmpColor;
        }
        return res;
    }

    /**
     * ��ȡ���²�ĵ��ʶ�Ӧ��״̬��Ϣ
     *
     * @param guessWord    �´�
     * @param PossibleWord ���ܴ�
     * @throws Exception �쳣
     */
    public static void getWordStatusInfo(String guessWord, Set<String> PossibleWord) throws Exception{
        int[] guessTimes = new int[3*3*3*3*3];
        int sum=0;
        Word tmpWord = new Word(guessWord);
        for (String pWord : PossibleWord) {
            tmpWord.CheckAns(pWord);
            int state;
            state = tmpWord.getState();
            guessTimes[state]++;
        }
        for (int i=0; i<3*3*3*3*3; i++){
            if(guessTimes[i]!=0) {
                sum+=guessTimes[i];
            }
        }
        ArrayList<StatusInfo> res = new ArrayList<>();
        for (int i=0; i<3*3*3*3*3; i++){
            if(guessTimes[i]!=0){
                double info;
                double p;
                p = (double) guessTimes[i] / (double) sum;
                info = Math.log(1 / p) / Math.log(2);
                StatusColor color = new StatusColor(getStatusColor(i));
                res.add(new StatusInfo(guessTimes[i],sum,info,color));
            }
        }
        res.sort(Collections.reverseOrder());
        StateInfoList = res;
    }
}


/**
 * ״̬����ɫ
 */
class StatusColor {
    LetterColor[] color;
    StatusColor(LetterColor[] sColor){
        color = sColor;
    }
}

/**
 * ���������Ӧ�÷�
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

/**
 * ״̬��Ϣ
 */
class StatusInfo  implements Comparable<StatusInfo>{
    int times;
    int sum;
    double info;
    StatusColor statusColor;
    StatusInfo(int t, int s, double i, StatusColor colors){
        times = t;
        sum = s;
        info = i;
        statusColor =  colors;
    }
    @Override
    public int compareTo(StatusInfo s){
        return Integer.compare(this.times, s.times);
    }
}