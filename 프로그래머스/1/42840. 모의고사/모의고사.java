import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] answer = {};
        
        int[] ansA = {1, 2, 3, 4, 5};
        int[] ansB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ansC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int idxA = 0;
        int idxB = 0;
        int idxC = 0;
        
        int[] cnt = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (idxA == ansA.length) {
                idxA = 0;
            }
            if (idxB == ansB.length) {
                idxB = 0;
            }
            if (idxC == ansC.length) {
                idxC = 0;
            }
            
            if (answers[i] == ansA[idxA]) {
                cnt[0]++;
            }
            if (answers[i] == ansB[idxB]) {
                cnt[1]++;
            }
            if (answers[i] == ansC[idxC]) {
                cnt[2]++;
            }
            
            idxA++;
            idxB++;
            idxC++;
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (cnt[i] == max) {
                list.add(i+1);
            }
        }
        
        
        return list;
    }
}