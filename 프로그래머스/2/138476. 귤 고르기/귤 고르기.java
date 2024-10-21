import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int ans = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int sum = 0;
        
        for (int num : list) {
            ans++;
            sum += num;
            if (sum >= k) {
                break;
            }
        }
        
        return ans;
    }
}