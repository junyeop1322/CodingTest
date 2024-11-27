import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String word = targets[i];
            int sum = 0;
            
            for (int j = 0; j < word.length(); j++) {
                int cnt = findMinNum(word.charAt(j), keymap);
                
                if (cnt == -1) {
                    sum = -1;
                    break;
                } else {
                    sum += cnt;
                }
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
    
    static int findMinNum(Character ch, String[] keymap) {
        boolean check = false;
        int num = Integer.MAX_VALUE;
        
        for (int i = 0; i < keymap.length; i++) {
            
            for (int j = 0; j < keymap[i].length(); j++) {
                if (ch == keymap[i].charAt(j)) {
                    check = true;
                    num = Math.min(num, j+1);
                    break;
                }
            }
        }
        
        if (!check) {
            return -1;
        } else {
            return num;
        }
    }
}