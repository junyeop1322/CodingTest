class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int ansA;
        int ansB;
        
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        
        String str = strA + strB;
        
        ansA = Integer.parseInt(str);
        
        ansB = 2 * a * b;
        
        if (ansA > ansB) {
            answer = ansA;
        } else {
            answer = ansB;
        }
        
        return answer;
    }
}