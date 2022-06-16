import java.io.File;
import java.io.PrintStream;
import java.util.*;

/**
 * 猜词算法
 */
public class GuessAlgorithm {

    /**
     * 记录是否为第一次计算，若是则导入本地文件
     */
    static boolean isFirst = true;

    /**
     * 保存颜色状态的可视化信息
     */
    static ArrayList<StatusInfo> StateInfoList;

    /**
     * 保存当前剩余的可能的单词的几率
     */
    static ArrayList<WordWithChance> PossibleWordChance;

    /**
     * 每种情况出现的加权概率
     */
    static double[] chance = new double[3*3*3*3*3];

    /**
     * 每种情况出现的次数
     */
    static int[] times = new int[3*3*3*3*3];

    /**
     * 所有可能单词的权重和
     */
    static double priorAll;

    /**
     * 所有单词总熵
     */
    static double eNow;

    /**
     * 可能单词的总数
     */
    static int possibilities;

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
     * @return String集合
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
        if(isFirst){
            wsList.clear();
            isFirst=false;
            String word;
            double score;
            double possibility;
            double entropy;
            File file = new File("src/Data/GuessWord.txt");
            // 导入单词
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
        //第一层循环，遍历所有合法的单词
        for (String lWord : LegalWord) {
            priorAll=0;
            Arrays.fill(chance, 0);
            Arrays.fill(times, 0);
            Word tmpWord = new Word(lWord);

            //遍历可能为答案的词
            for (String pWord : PossibleWord) {
                tmpWord.CheckAns(pWord);
                int state;
                state = tmpWord.getState();
                chance[state] += WordList.WordPrior.get(pWord);
                times[state]++;
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

    /**
     * 计算新的熵
     *
     * @param PossibleWord 当前可能的单词
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
     * 获得显示列表，获取每一个可能是答案的词成为答案的概率
     * 获取的展示列表保存在PossibleWordChance中
     *
     * @param PossibleWord 可能是答案的词
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
     * 得到当前状态的颜色
     *
     * @param status 状态
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
     * 获取所猜测的单词对应的状态信息
     *
     * @param guessWord    猜词
     * @param PossibleWord 可能词
     * @throws Exception 异常
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
 * 状态的颜色
 */
class StatusColor {
    LetterColor[] color;
    StatusColor(LetterColor[] sColor){
        color = sColor;
    }
}

/**
 * 单词与其对应得分
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
 * 状态信息
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