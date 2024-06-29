class Solution {
    public int[] solution(long n) {
        int[] answer;
        
        String str = Long.toString(n);
        
        answer = new int[str.length()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = str.charAt(answer.length - 1 - i) - 48;
        }
        
        return answer;
    }
}