import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        
        Stack<Integer> stk = new Stack<>();
        
        for (int i=1;i<=order.length;i++) {
            stk.push(i);
            
            while (!stk.isEmpty()) {
                if (stk.peek()==order[idx]) {
                    stk.pop();
                    idx++;
                    answer++;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}