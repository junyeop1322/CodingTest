import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[] {begin, Integer.toString(0)});
        
        while (!q.isEmpty()) {
            String[] cur = q.poll();
            String str = cur[0];
            int cnt = Integer.parseInt(cur[1]);
            
            if (str.equals(target)) {
                return cnt;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) {
                    continue;
                }
                
                String s = words[i];
                int count = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (str.charAt(j) != s.charAt(j)) {
                        count++;
                    }
                }
                
                if (count == 1) {
                    q.add(new String[] {s, Integer.toString(cnt+1)});
                    visited[i] = true;
                }
            }
            
        }
        
        return answer;
    }
}