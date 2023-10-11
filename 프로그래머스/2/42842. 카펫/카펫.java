class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        for (int i = 3; i < sum; i++) {
            int j = sum / i;
            
            if (sum % i == 0 && j >= 3) {
                int c = Math.max(i, j);
                int r = Math.min(i, j);
                int cen = (c - 2) * (r - 2);
                
                if (cen == yellow) {
                    answer[0] = c;
                    answer[1] = r;
                    
                    return answer;
                }
                    
            }
            
        }
        return answer;
    }
}