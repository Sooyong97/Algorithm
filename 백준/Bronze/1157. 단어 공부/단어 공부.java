import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Map<String, Integer> count = new HashMap<>();

        for (char c : str.toCharArray()) {
            c = Character.toUpperCase(c);
            count.put(Character.toString(c), count.getOrDefault(Character.toString(c), 0) + 1);
        }

        int max_count = Integer.MIN_VALUE;
        int count_same = 0;
        for (int i : count.values()) {
            if (i > max_count) {
                max_count = i;
                count_same = 0;
            }
            else if (i == max_count) {
                count_same++;
            }
        }

        if (count_same > 0){
            System.out.println("?");
        }
        else{
            System.out.println(findKeyByValue(count, max_count));
        }
    }

    public static String findKeyByValue(Map<String, Integer> map, int value) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return null;
    }
}
