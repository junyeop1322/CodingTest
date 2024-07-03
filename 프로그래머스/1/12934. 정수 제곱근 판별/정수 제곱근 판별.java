import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long num =(long) Math.sqrt(n);
        
        if ((long)Math.pow(num, 2) == n) {
            answer = (long) Math.pow(num+1, 2);
        } else {
            answer = -1;
        }
        
        return answer;
    }
}