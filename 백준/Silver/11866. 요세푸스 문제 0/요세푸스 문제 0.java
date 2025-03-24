import java.util.*;
import java.io.*;

public class Main {
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		sb.append("<");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for(int i=1; i<N+1; i++) {
			q.add(i);
		}

		while( q.size() > 1 ) {
			for(int i=0; i<K-1; i++) {
				int temp = q.poll();
				q.add(temp);
			}
			int num = q.poll();
			sb.append(num).append(", ");
		
		}
		
		int num = q.poll();
		sb.append(num).append(">");

		System.out.println(sb);
	}
}