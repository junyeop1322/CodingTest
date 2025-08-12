import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        while(n > 0) {
            int num = pq.poll();
            
            if (num == 0) {
                break;
            }
            
            num--;
            pq.offer(num);
            
            n--;
        }
        
        for (int num : pq) {
            answer += num*num;
        }
        
        return answer;
    }
}