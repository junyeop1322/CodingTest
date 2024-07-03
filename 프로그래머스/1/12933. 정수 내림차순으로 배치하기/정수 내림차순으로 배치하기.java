import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String str = Long.toString(n);
        
        int[] arr = new int[str.length()];
        
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        
        Arrays.sort(arr);
        
        String str2 = "";
        
        for (int i = str.length()-1; i >= 0; i--) {
            str2 += arr[i];
        } 
        
        answer = Long.parseLong(str2);
        
        return answer;
    }
}