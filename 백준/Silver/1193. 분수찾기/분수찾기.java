import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int num = 0;
        
        if(X==1) {
            bw.write("1/1");
        } else if(X==2) {
            bw.write("1/2");
        }
        
        for(int i=1; i<X; i++) {
            num += i;

            if(num >= X) { 
                num -= i;
                int sequence = X - num;

                if(i%2==0) {
                    bw.write(sequence+"/"+((i+1)-sequence));
                } else {
                    bw.write(((i+1)-sequence)+"/"+sequence);
                }
                break;
            }
        }

        br.close();
        bw.close();
    }
}