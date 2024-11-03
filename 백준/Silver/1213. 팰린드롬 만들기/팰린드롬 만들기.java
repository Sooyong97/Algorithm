import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length(); i++) {
            map.put(name.charAt(i), map.getOrDefault(name.charAt(i), 0) + 1);
        }

        int odd = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                odd++;
                if (odd > 1){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        Map<Character, Integer> sorted_map = new TreeMap<>(map);

        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        StringBuilder center = new StringBuilder();

        for (char c : sorted_map.keySet()) {
            if (sorted_map.get(c) % 2 == 1) {
                center.append(Character.toString(c));
                if (sorted_map.get(c)>1) {
                    front.append(Character.toString(c).repeat((sorted_map.get(c) -1) / 2));
                    back.append(Character.toString(c).repeat((sorted_map.get(c) -1 )/ 2));
                }
            } else{
                front.append(Character.toString(c).repeat(sorted_map.get(c) / 2));
                back.append(Character.toString(c).repeat(sorted_map.get(c) / 2));
            }
        }

        System.out.print(front.toString() + center.toString() + back.reverse().toString());

    }
}
