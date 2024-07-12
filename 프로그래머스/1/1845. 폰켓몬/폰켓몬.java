import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> hash = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        
        int num1 = hash.size();
        int num2 = nums.length / 2;
        
        answer = Math.min(num1, num2);
        
        return answer;
    }
}