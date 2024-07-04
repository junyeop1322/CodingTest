class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        answer[0] = -1;
        
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            int cnt = -1;
            for (int j = i-1; j >= 0; j--) {
                if (ch == s.charAt(j)) {
                    cnt = i - j;
                    break;
                }
            }
            answer[i] = cnt;
            
        }
        
        return answer;
    }
}