import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ')') {
                if (stk.isEmpty()) {
                    return false;
                } else {
                    stk.pop();
                }
            } else {
                stk.push(ch);
            }
        }
        
        if (!stk.isEmpty()) {
            return false;
        }
        
        return true;
    }
}