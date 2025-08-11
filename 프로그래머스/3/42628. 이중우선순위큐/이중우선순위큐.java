import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (pq1.size() < 1 && str.equals("D")) {
                continue;
            }
            
            if (str.equals("I")) {
                pq1.offer(num);
                pq2.offer(num);
                continue;
            }
            
            if (num < 0) {
                int min = pq1.poll();
                pq2.remove(min);
            } else {
                int max = pq2.poll();
                pq1.remove(max);
            }
        }
        
        if (pq1.size() > 0) {
            answer[0] = pq2.poll();
            answer[1] = pq1.poll();
        }
        
        return answer;
    }
}