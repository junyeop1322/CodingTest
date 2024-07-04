class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxA = 0;
        int maxB = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            
            if (a > b) {
                maxA = Math.max(maxA, a);
                maxB = Math.max(maxB, b);
            } else {
                maxA = Math.max(maxA, b);
                maxB = Math.max(maxB, a);
            }   
        }
        
        answer = maxA * maxB;
        
        return answer;
    }
}