import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (!stk.isEmpty() && ch == stk.peek()) {
                stk.pop();
            } else {
                stk.push(ch);
            }
        }
        
        if (stk.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}