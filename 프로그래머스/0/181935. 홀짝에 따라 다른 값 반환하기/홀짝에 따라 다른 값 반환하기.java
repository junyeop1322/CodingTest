class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if (n % 2 == 0) { // n이 짝수이면
            for (int i = 0; i <= n/2; i++) {
                answer = answer + (i * 2) * (i * 2);
            }
            
        } else { // n이 홀수이면
            for (int i = 0; i <= n; i++) {
                if (i % 2 == 1) {
                    answer = answer + i;
                }
            }
            
        }
                
        return answer;
    }
}