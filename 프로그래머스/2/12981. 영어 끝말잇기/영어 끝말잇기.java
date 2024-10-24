import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            if (list.contains(words[i]) || check(list.get(list.size()-1), words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            
            list.add(words[i]);
        }
        
        return answer;
    }
    
    static boolean check (String str1, String str2) {
        if (str1.charAt(str1.length()-1) == str2.charAt(0)) {
            return false;
        }
        
        return true;
    }
}