import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        int num = score.length / m;
        
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                 answer += score[score.length - (i * m)];
            }
        }
        
        answer *= m;
        
        return answer;
    }
}