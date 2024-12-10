import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[]arr;
    public static void main(String[] args) throws IOException {
     N = Integer.parseInt(br.readLine());
     arr = new int[N];
     HashMap<Integer, Integer> hm = new HashMap<>();
     for(int i=0; i<N; i++){
         arr[i] = Integer.parseInt(br.readLine());
         hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
     }
     int [] count = new int[N];
     for(int i=0; i<N; i++){
         int cur = arr[i];
         int sq = (int) Math.sqrt(cur);
         if(sq*sq == cur){
             count[i] = -hm.getOrDefault(sq, 0);
         }else{
             count[i] = 0;
         }
         for(int j=1; j<=sq; j++){
             if(cur%j != 0){
                 continue;
             }
             count[i] += hm.getOrDefault(j,0) + hm.getOrDefault(cur/j,0);
         }
     }
     for(int i=0; i<N; i++){
         System.out.println(count[i]-1);
     }

    }


}