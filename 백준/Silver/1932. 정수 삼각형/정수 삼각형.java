import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        ArrayList<Integer>[] tri = new ArrayList[size];

        for (int i = 0; i < size; i++) {
            tri[i] = new ArrayList<>();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                tri[i].add(sc.nextInt());
            }
        }

        for (int i = size - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                tri[i].set(j, tri[i].get(j) + Math.max(tri[i + 1].get(j), tri[i + 1].get(j + 1)));
            }
        }

        System.out.println(tri[0].get(0));
    }
}
