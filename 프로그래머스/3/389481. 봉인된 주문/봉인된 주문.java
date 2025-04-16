import java.util.*;

class Solution {
    
    static long calc(String str) {
        long num = 0;
        long w = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            num += ((int) c - 96) * w;
            w *= 26;
        }
        
        return num;
    }
    
    static String reCalc(long n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
        n--;
        int r = (int)(n % 26);
        sb.append((char)(r + 'a'));
        n /= 26;
    }
    return sb.reverse().toString();
    }
    
    public String solution(long n, String[] bans) {
        
        Arrays.sort(bans, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                return s1.compareTo(s2);
            }
        });
        
        long counts = 0;
        for (String ban : bans) {
            long banNum = calc(ban);
            if (banNum - counts <= n) counts++;
            else break;
        }
        
        n += counts;
        
        return reCalc(n);
    }
}