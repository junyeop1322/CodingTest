import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int i : topping) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        
        for (int i : topping) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
            
            if (map2.get(i) - 1 == 0) {
                map2.remove(i);
            } else {
                map2.put(i, map2.get(i)-1);
            }
            
            if (map1.size() == map2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}