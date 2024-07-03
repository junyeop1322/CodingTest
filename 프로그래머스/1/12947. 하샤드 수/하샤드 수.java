class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        
        int num = 0;
        
        String str = Integer.toString(x);
        
        
        for (int i = 0; i < str.length(); i++) {
            num += str.charAt(i) - '0';
        }
        
        if (x % num == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        
        return answer;
    }
}