import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        int sum = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        
        while(true) {
            
            if (idx == truck_weights.length && sum == 0) {
                break;
            }
            
            sum -= q.poll();
            
            if (idx == truck_weights.length) {
                answer++;
                continue;
            }
            
            if (sum+truck_weights[idx] <= weight) {
                sum += truck_weights[idx];
                q.add(truck_weights[idx]);
                idx++;
            } else {
                q.add(0);
            }
            
            answer++;
        }
        
        return answer;
    }
}