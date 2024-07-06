import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        
        Stack<Integer> st = new Stack<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                st.push(arr[i]);
            } else if (st.peek() != arr[i]) {
                st.push(arr[i]);
            }
        }
        
        answer = new int[st.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[answer.length - 1 - i] = st.pop();
        }
        
        return answer;
    }
}