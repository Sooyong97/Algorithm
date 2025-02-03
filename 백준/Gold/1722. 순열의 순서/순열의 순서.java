import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        int N, Q;
        long F[] = new long[21];
        int  S[] = new int[21];
        boolean visited[] = new boolean[21];
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine()," ");
        Q = Integer.parseInt(st.nextToken());
        
        F[0] = 1;
        for(int i = 1 ; i <= N ; i++) {
            F[i] = F[i - 1] * i;
        }
        
        if(Q == 1) {
            long K = Long.parseLong(st.nextToken());
            
            for(int i = 0 ; i < N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    if(visited[j]) continue;
                    
                    if(F[N - i - 1] < K) {
                        K -= F[N - i - 1];
                    }
                    else {
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
            for(int i = 0 ; i < N ; i++) {
                System.out.print(S[i] + " ");
            }
        }

        else {
            for(int i = 0 ; i < N ; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            
            long ans = 1;
            
            for(int i = 0 ; i < N ; i++) {
                for(int j = 1 ; j < S[i] ; j++) {
                    if(visited[j]) continue;
                    ans += F[N - i - 1];
                }
                visited[S[i]] = true;
            }
            System.out.println(ans);
        }
    }
}