class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long num1 = t.length();
        long num2 = p.length();
        
        long pNum = Long.parseLong(p);
        
        for (int i = 0; i < num1 - num2 + 1; i++) {
            String str = "";
            for (int j = i; j < i + num2; j++) {
                str += t.charAt(j);
            }
            long num = Long.parseLong(str);
            
            if (pNum >= num) {
                answer++;
            }
            
        }
        
        
        return answer;
    }
}