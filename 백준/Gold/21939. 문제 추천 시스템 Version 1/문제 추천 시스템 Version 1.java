import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;

    public static class Pair implements Comparable<Pair>{
        int P, L;

        Pair(int p, int l){
            this.P = p;
            this.L = l;
        }
        
        @Override
        public int compareTo(Pair p) {
            if(this.L == p.L) {
                return this.P - p.P;
            }
            else {
                return this.L - p.L;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        TreeSet<Pair> asc = new TreeSet<Pair>();
        Map<Integer,Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            asc.add(new Pair(P, L));
            map.put(P, L);
        }

        M = Integer.parseInt(br.readLine());

        for(int j=0; j<M; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    System.out.println(asc.last().P);
                }
                else {
                    System.out.println(asc.first().P);
                }
            }
            else if(cmd.equals("add")){
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                asc.add(new Pair(P, L));
                map.put(P, L);
            }
            else {
                int P = Integer.parseInt(st.nextToken());
                int L = map.get(P);
                asc.remove(new Pair(P, L));
                map.remove(P);
            }
        }
    }
}