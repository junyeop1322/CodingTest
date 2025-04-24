import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for (int n : ingredient) {
            list.add(n);
            
            while(list.size() >= 4) {
                int size = list.size()-1;
                
                if (list.get(size) != 1 || list.get(size-1) != 3 || list.get(size-2) != 2 || list.get(size-3) != 1) {
                    break;
                }
                
                answer++;
                for (int j = 0; j < 4; j++) {
                    list.remove(list.size()-1);
                }
            }
        }
        
        
        return answer;
    }
}