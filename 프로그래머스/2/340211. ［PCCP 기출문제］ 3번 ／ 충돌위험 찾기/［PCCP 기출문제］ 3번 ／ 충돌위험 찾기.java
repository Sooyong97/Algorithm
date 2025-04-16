import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int nRobot = routes.length;
        
        // 로봇의 현재 위치와 목표 추적
        int[][] robotPositions = new int[nRobot][2]; // [r, c]
        int[] targetIndices = new int[nRobot]; // 다음 목표 포인트 인덱스
        boolean[] finished = new boolean[nRobot]; // 운송 완료 여부
        
        // 초기화: 모든 로봇은 첫 포인트에서 시작
        for (int i = 0; i < nRobot; i++) {
            int firstPointNum = routes[i][0] - 1; // 첫 포인트 번호 (0-indexed)
            robotPositions[i][0] = points[firstPointNum][0]; // r 좌표
            robotPositions[i][1] = points[firstPointNum][1]; // c 좌표
            targetIndices[i] = 1; // 다음 목표는 경로의 두 번째 포인트
        }
        
        // 위험 상황 확인을 위한 초기 위치 카운트
        // 초기 위치에서도 로봇들이 겹칠 수 있음
        Map<String, Integer> initialPositionCount = new HashMap<>();
        for (int i = 0; i < nRobot; i++) {
            String pos = robotPositions[i][0] + "," + robotPositions[i][1];
            initialPositionCount.put(pos, initialPositionCount.getOrDefault(pos, 0) + 1);
        }
        
        // 초기 위치에서의 위험 상황 카운트
        for (int count : initialPositionCount.values()) {
            if (count >= 2) {
                answer++;
            }
        }
        
        // 모든 로봇이 운송을 완료할 때까지 시뮬레이션
        boolean anyActive = true;
        
        while (anyActive) {
            // 다음 위치 계산
            int[][] nextPositions = new int[nRobot][2];
            
            for (int i = 0; i < nRobot; i++) {
                if (finished[i]) continue;
                
                // 현재 위치 복사
                nextPositions[i][0] = robotPositions[i][0];
                nextPositions[i][1] = robotPositions[i][1];
                
                // 다음 목표 포인트 확인
                if (targetIndices[i] < routes[i].length) {
                    int targetPointNum = routes[i][targetIndices[i]] - 1; // 목표 포인트 번호 (0-indexed)
                    int targetR = points[targetPointNum][0]; // 목표 r 좌표
                    int targetC = points[targetPointNum][1]; // 목표 c 좌표
                    
                    int currentR = robotPositions[i][0];
                    int currentC = robotPositions[i][1];
                    
                    // 목표에 도착했는지 확인
                    if (currentR == targetR && currentC == targetC) {
                        targetIndices[i]++;
                        
                        // 경로를 모두 완료했는지 확인
                        if (targetIndices[i] >= routes[i].length) {
                            finished[i] = true;
                            continue;
                        }
                        
                        // 다음 목표 설정
                        targetPointNum = routes[i][targetIndices[i]] - 1;
                        targetR = points[targetPointNum][0];
                        targetC = points[targetPointNum][1];
                    }
                    
                    // 최단 경로로 이동 (r 좌표 우선)
                    if (currentR < targetR) {
                        nextPositions[i][0]++;
                    } else if (currentR > targetR) {
                        nextPositions[i][0]--;
                    } else if (currentC < targetC) {
                        nextPositions[i][1]++;
                    } else if (currentC > targetC) {
                        nextPositions[i][1]--;
                    }
                } else {
                    finished[i] = true;
                }
            }
            
            // 위치 업데이트 및 위험 상황 계산
            Map<String, Integer> positionCount = new HashMap<>();
            
            for (int i = 0; i < nRobot; i++) {
                if (finished[i]) continue;
                
                // 위치 업데이트
                robotPositions[i][0] = nextPositions[i][0];
                robotPositions[i][1] = nextPositions[i][1];
                
                // 위치 카운트
                String pos = robotPositions[i][0] + "," + robotPositions[i][1];
                positionCount.put(pos, positionCount.getOrDefault(pos, 0) + 1);
            }
            
            // 위험 상황 카운트 (한 시간에 여러 위치에서 발생할 수 있음)
            for (int count : positionCount.values()) {
                if (count >= 2) {
                    answer++;
                }
            }
            
            // 활성 로봇 체크
            anyActive = false;
            for (int i = 0; i < nRobot; i++) {
                if (!finished[i]) {
                    anyActive = true;
                    break;
                }
            }
        }
        
        return answer;
    }
}