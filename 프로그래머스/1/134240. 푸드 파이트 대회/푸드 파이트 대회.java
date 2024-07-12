class Solution {
    public String solution(int[] food) {
        String str = "";
        String answer = "";
        
        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 == 1) {
                if (food[i] == 1) {
                    continue;
                } else {
                    for (int j = 0; j < (food[i] - 1) / 2; j++) {
                        str += Integer.toString(i);
                    }
                }
            } else {
                for (int j = 0; j < food[i] / 2; j++) {
                    str += Integer.toString(i);
                }
            }         
        }
        
        answer += str;
        answer += "0";
        
        for (int i = 0; i < str.length(); i++) {
            answer += str.charAt(str.length() - 1 - i);
        }
        
        return answer;
    }
}