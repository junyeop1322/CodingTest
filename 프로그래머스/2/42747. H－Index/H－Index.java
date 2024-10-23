import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int cnt = 1;
        for (int i = citations.length-1; i >= 0; i--) {
            if (cnt <= citations[i]) {
                answer = cnt;
            }
            cnt++;
        }
        
        return answer;
    }
}