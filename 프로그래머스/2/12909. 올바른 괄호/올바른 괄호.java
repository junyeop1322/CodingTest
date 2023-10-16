class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int open = 0;
        int close = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            }
            if (s.charAt(i) == ')') {
                close++;
            }
            
            if (open < close) {
                return false;
            }
        }
        
        if (open == close) {
            return true;
        }
        
        return false;
    }
}