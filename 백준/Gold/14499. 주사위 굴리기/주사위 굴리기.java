import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[] dice = new int[6]; // 주사위의 각 면을 나타냄
    static int x, y; // 주사위의 현재 좌표
    static int N, M; // 지도의 크기

    // 주사위를 동, 서, 북, 남으로 굴리는 함수
    public static void roll(int command) {
        int temp;
        switch (command) {
            case 1: // 동
                if (y + 1 >= M) return; // 지도 경계 체크
                y++;
                temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 2: // 서
                if (y - 1 < 0) return; // 지도 경계 체크
                y--;
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
            case 3: // 북
                if (x - 1 < 0) return; // 지도 경계 체크
                x--;
                temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
            case 4: // 남
                if (x + 1 >= N) return; // 지도 경계 체크
                x++;
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
        }

        // 주사위 바닥면과 지도의 칸 값 복사
        if (map[x][y] == 0) {
            map[x][y] = dice[5];
        } else {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }

        // 주사위의 윗 면 출력
        System.out.println(dice[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        int K = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            int command = sc.nextInt();
            roll(command);
        }

        sc.close();
    }
}
