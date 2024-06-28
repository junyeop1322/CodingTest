import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for (int a = 0; a < commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int[] arr = Arrays.copyOfRange(array, i-1, j);
            
            Arrays.sort(arr);
            
            answer.add(arr[k-1]);
            
        }
        
        return answer;
    }
}