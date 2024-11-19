import java.util.*;

public class Main {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            int N = sc.nextInt();

            set.add(N%42);

        }

        System.out.println(set.size());
    }
}
