import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int[] delete_list) {
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            
            boolean chk = true;
            
            for (int j = 0; j < delete_list.length; j++) {
                if (num == delete_list[j]) {
                    chk = false;
                    break;
                }
            }
            
            if (chk) {
                ans.add(num);
            }
        }
        
        return ans;
    }
}