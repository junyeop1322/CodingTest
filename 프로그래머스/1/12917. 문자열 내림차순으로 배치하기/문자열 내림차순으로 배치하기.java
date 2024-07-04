import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length; i++) {
            answer += arr[arr.length - 1 - i];
        }
        
        return answer;
    }
}