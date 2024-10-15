class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for (int i = 1; i <= n/2; i++) {
            if (sumCheck(n, i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean sumCheck(int n, int num) {
        boolean check = false;
        int sum = 0;
        for (int i = num; i <= n; i++) {
            sum += i;
            if (sum == n) {
                check = true;
                break;
            } else if (sum > n) {
                break;
            }
        }
        
        return check;
    }
}