class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        int ans = -1;
        
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                ans = i;
            }
        }
        
        answer = "김서방은 " + Integer.toString(ans) + "에 있다";
        
        
        return answer;
    }
}