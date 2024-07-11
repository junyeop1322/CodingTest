class Solution {
    public int solution(int number, int limit, int power) {
        int[] count = new int[number+1];
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }
        
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        
        return answer;
    }
}