import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int[] arr = timelogs[i];
            
            int timeA = schedules[i];
            int timeB;
            if (timeA % 100 >= 50) {
                timeB = timeA + 50;
                
                if (timeB >= 2400) {
                    timeB -= 2400;
                }
            } else {
                timeB = timeA + 10;
            }
            
            System.out.println(i + " -> time : " + timeA + ", timeB : " + timeB);
            
            int count = 0;
            int cnt = startday;
            
            for (int j = 0; j < 7; j++) {
                if (cnt % 7 != 0 && cnt % 7 != 6) {
                    if (arr[j] <= timeB) {
                        count++;
                    }
                }
                cnt++;
            }
            
            if (count == 5) {
                System.out.println(i);
                answer++;
            }
        }
        
        return answer;
    }
}