class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String s = Integer.toString(n, 2);
        int cntOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cntOne++;
            }
        }
        answer = n;
        while (true) {
            answer++;
            
            String str = Integer.toString(answer, 2);
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    cnt++;
                }
            }
            
            if (cnt == cntOne) {
                break;
            }
            
        }
        
        return answer;
    }
}