import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] durability = new int[2 * N];
        boolean[] robots = new boolean[2 * N];

        for (int i = 0; i < 2 * N; i++) {
            durability[i] = sc.nextInt();
        }

        int steps = 0;

        while (true) {
            steps++;

            rotateBelt(durability, robots, N);

            moveRobots(durability, robots, N);

            addRobot(durability, robots);

            if (countZeroDurability(durability) >= K) {
                System.out.println(steps);
                break;
            }
        }
    }

    private static void rotateBelt(int[] durability, boolean[] robots, int N) {
        int lastDurability = durability[durability.length - 1];
        System.arraycopy(durability, 0, durability, 1, durability.length - 1);
        durability[0] = lastDurability;
        for (int i = robots.length - 1; i > 0; i--) {
            robots[i] = robots[i - 1];
        }
        robots[0] = false;
        robots[N - 1] = false;
    }

    private static void moveRobots(int[] durability, boolean[] robots, int N) {
        for (int i = N - 2; i >= 0; i--) {
            if (robots[i] && !robots[i + 1] && durability[i + 1] > 0) {
                robots[i] = false;
                robots[i + 1] = true;
                durability[i + 1]--;

                if (i + 1 == N - 1) {
                    robots[i + 1] = false;
                }
            }
        }
    }

    private static void addRobot(int[] durability, boolean[] robots) {
        if (durability[0] > 0) {
            robots[0] = true;
            durability[0]--;
        }
    }

    private static int countZeroDurability(int[] durability) {
        int count = 0;
        for (int d : durability) {
            if (d == 0) {
                count++;
            }
        }
        return count;
    }
}
