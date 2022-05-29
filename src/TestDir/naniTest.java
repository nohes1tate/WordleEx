import java.util.HashSet;
import java.util.Set;

public class naniTest {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(5);
        s.add(6);
        s.add(7);
        for(int i:s){
            System.out.println(i);
        };
        for(int i:s){
            System.out.println(i);
        }
    }
}
