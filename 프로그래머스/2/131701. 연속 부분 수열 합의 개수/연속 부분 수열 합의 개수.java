import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < elements.length; i++) {
            stk.push(elements[i]);
        }
        
        Set<Integer> set = new HashSet<>();
        
        int n = elements.length;
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            
            for (int j = 0; j < n; j++) {
                sum += elements[(i+j) % n];
                stk.push(sum);
                set.add(sum);
            }
        }
        
        answer = set.size();
        
        return answer;
    }
}