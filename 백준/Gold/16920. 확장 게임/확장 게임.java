import java.util.*;
import java.io.*;

public class Main {

    static int N, M, P; // 맵의 행, 열 크기, 플레이어 수
    static int[] s; // 각 플레이어의 확장 거리
    static int[] counts; // 각 플레이어가 점령한 칸의 개수
    static char[][] map; // 게임 맵
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 x 방향 배열
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동을 위한 y 방향 배열

    // 각 플레이어별로 확장 가능한 성들의 좌표를 저장할 큐 배열
    // playerQueues[i]는 i번 플레이어의 다음 라운드 시작 지점들을 담는다.
    static Queue<int[]>[] playerQueues;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        counts = new int[P + 1];
        s = new int[P + 1];
        
        // playerQueues 배열 초기화 및 각 큐를 LinkedList로 생성
        playerQueues = new LinkedList[P + 1];
        for (int i = 1; i <= P; i++) {
            playerQueues[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        // 맵 초기화 및 초기 성들의 위치를 playerQueues에 추가, counts 업데이트
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] >= '1' && map[i][j] <= '9') { // 플레이어의 성이라면
                    int playerNum = map[i][j] - '0';
                    playerQueues[playerNum].add(new int[]{i, j}); // 해당 플레이어의 큐에 추가
                    counts[playerNum]++; // 점령 개수 증가
                }
            }
        }

        solve(); // 시뮬레이션 시작
    }

    static void solve() {
        boolean expandedThisRound; // 현재 라운드에서 어떤 플레이어라도 확장을 했는지 여부

        while (true) {
            expandedThisRound = false; // 새 라운드 시작 시 초기화

            // 각 플레이어별로 확장 진행
            for (int player = 1; player <= P; player++) {
                // 현재 플레이어의 큐가 비어있다면, 더 이상 확장할 성이 없으므로 다음 플레이어로 넘어감
                if (playerQueues[player].isEmpty()) {
                    continue;
                }

                // 이번 라운드에서 이 플레이어가 확장할 시작 지점들을 담을 임시 큐
                // playerQueues[player]에 있는 모든 지점을 여기에 옮겨와 BFS 시작
                Queue<int[]> currentRoundExpansionQueue = new LinkedList<>();
                while(!playerQueues[player].isEmpty()){
                    currentRoundExpansionQueue.add(playerQueues[player].poll());
                }

                int stepsTaken = 0; // 현재 플레이어가 이번 라운드에서 이동한 거리
                // currentRoundExpansionQueue가 비어있지 않고, 해당 플레이어의 최대 확장 거리(s[player]) 미만일 때까지 반복
                while (!currentRoundExpansionQueue.isEmpty() && stepsTaken < s[player]) {
                    int size = currentRoundExpansionQueue.size(); // 현재 단계에서 처리할 성의 개수
                    boolean playerExpandedStep = false; // 현재 단계에서 이 플레이어가 확장했는지 여부

                    // 현재 단계의 모든 성들에 대해 BFS 수행
                    for (int k = 0; k < size; k++) {
                        int[] cur = currentRoundExpansionQueue.poll();
                        int cx = cur[0];
                        int cy = cur[1];

                        for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                            int nx = cx + dx[i];
                            int ny = cy + dy[i];

                            // 맵 범위 체크
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            
                            // 빈 칸(.)만 점령 가능
                            if (map[nx][ny] == '.') { 
                                map[nx][ny] = (char) (player + '0'); // 맵에 플레이어 번호로 표시
                                counts[player]++; // 점령 개수 증가
                                currentRoundExpansionQueue.add(new int[]{nx, ny}); // 이번 라운드 다음 단계 확장을 위해 임시 큐에 추가
                                playerQueues[player].add(new int[]{nx, ny}); // 다음 라운드 확장을 위해 해당 플레이어 큐에 추가
                                expandedThisRound = true; // 전체 라운드에서 확장이 일어났음을 표시
                                playerExpandedStep = true; // 현재 플레이어가 현재 단계에서 확장했음을 표시
                            }
                        }
                    }
                    if(!playerExpandedStep) break; // 현재 단계에서 더 이상 확장할 수 없다면, 이 플레이어의 이번 라운드 확장은 종료
                    stepsTaken++; // 이동 거리 증가
                }
            }
            
            // 만약 이번 라운드에서 어떤 플레이어도 확장을 하지 않았다면 게임 종료
            if (!expandedThisRound) {
                break;
            }
        }

        // 최종 결과 출력
        for (int i = 1; i <= P; i++) {
            System.out.print(counts[i] + " ");
        }
        System.out.println(); // 마지막에 줄바꿈
    }
}