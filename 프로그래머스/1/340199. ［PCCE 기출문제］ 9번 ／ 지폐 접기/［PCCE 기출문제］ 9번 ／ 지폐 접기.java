import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = Integer.MAX_VALUE;
        
        int w1 = wallet[0];
        int w2 = wallet[1];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {bill[0], bill[1], 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int b1 = cur[0];
            int b2 = cur[1];
            int cnt = cur[2];
            
            if ((w1 >= b1 && w2 >= b2) || (w1 >= b2 && w2 >= b1)) {
                answer = Math.min(answer, cnt);
            }
            
            if (b1 == 1 && b2 == 1) {
                break;
            }
            
            if (b1 > b2) {
                q.add(new int[] {b1/2, b2, cnt+1});    
            } else {
                q.add(new int[] {b1, b2/2, cnt+1});    
            }
        }
        
        return answer;
    }
}