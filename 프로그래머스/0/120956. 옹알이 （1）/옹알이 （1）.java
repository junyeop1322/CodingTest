class Solution {
    
    static String[] words = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String str : babbling) {
            for (String word : words) {
                if (str.contains(word)) {
                    str = str.replace(word, " ");
                }
            }
            
            str = str.replace(" ", "");
            
            if (str.equals("")) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
}