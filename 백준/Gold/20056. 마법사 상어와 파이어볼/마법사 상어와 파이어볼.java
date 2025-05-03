import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static int[][] direction = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    static class fireball {
        int r, c, m, s, d;

        public fireball(int r, int c, int m, int s, int d) {
            this.r = r; this.c = c; this.m = m; this.s = s; this.d = d;
        }

        public void setRC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<fireball> fireballs = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireball fb = new fireball(r, c, m, s, d);
            fireballs.add(fb);
        }

        while (K-- > 0) {
            if (fireballs.isEmpty()) break;

            HashMap<String, List<fireball>> map = new HashMap<>();
            // 이동
            for (fireball fb : fireballs) {
                move(fb);
                String key = fb.r + " " + fb.c;
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(fb);
            }

            // 합침
            List<fireball> newFireballs = new ArrayList<>();
            for (List<fireball> list : map.values()) {
                if (list.size() == 1) {
                    newFireballs.add(list.get(0));
                } else {
                    int sumM = 0; int sumS = 0;
                    boolean allOdd = true; boolean allEven = true;
                    for (fireball fb : list) {
                        sumM += fb.m;
                        sumS += fb.s;
                        if (fb.d % 2 == 0) allOdd = false;
                        else allEven = false;
                    }

                    sumM /= 5;
                    if (sumM == 0) continue;

                    sumS /= list.size();
                    int r = list.get(0).r; int c = list.get(0).c;

                    int[] newDir = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                    for (int d : newDir) {
                        newFireballs.add(new fireball(r, c, sumM, sumS, d));
                    }
                }
            }

            fireballs = newFireballs;
        }

        int result = 0;
        for (fireball fb : fireballs) {
            result += fb.m;
        }

        System.out.println(result);
    }

    static void move(fireball fb) {
        int[] d = direction[fb.d];
        int newR = (fb.r + d[0] * fb.s - 1 + N * 1000) % N + 1;
        int newC = (fb.c + d[1] * fb.s - 1 + N * 1000) % N + 1;
        fb.setRC(newR, newC);
    }
}