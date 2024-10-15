import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < str.length; i++) {
            int num = Integer.parseInt(str[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        answer += Integer.toString(min) + " " + Integer.toString(max);
        
        return answer;
    }
}