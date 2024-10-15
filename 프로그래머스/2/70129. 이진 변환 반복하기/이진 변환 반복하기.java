import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 1;
        int cntZero = 0;
        
        while(true) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    cntZero++;
                } else {
                    count++;
                }
            }
            
            if (count == 1) {
                break;
            } else {
                s = Integer.toString(count, 2);
            }
            
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = cntZero;
        
        return answer;
    }
}