import java.util.*;

class Solution {
    public List<Integer> solution(int[] numlist, int n) {
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numlist.length; i++) {
            list.add(numlist[i]);
        }
        
        final int k = n;
        
        Collections.sort(list, (o1, o2) -> {
           if (Math.abs(o1-k) == Math.abs(o2-k)) {
               return o2 - o1;
           }
            return Math.abs(o1-k) - Math.abs(o2-k);
        });
        
        return list;
    }
}