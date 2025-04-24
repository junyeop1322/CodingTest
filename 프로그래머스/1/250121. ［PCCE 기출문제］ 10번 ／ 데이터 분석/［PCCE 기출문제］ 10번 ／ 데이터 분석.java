import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        
        int n = 0, m = 0;
        
        String[] words = {"code", "date", "maximum", "remain"};
        for (int i = 0; i < 4; i++) {
            if (words[i].equals(ext)) {
                n = i;
            }
            if (words[i].equals(sort_by)) {
                m = i;
            }
        }
        
        final int k = m;
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][n] < val_ext) {
                answer.add(data[i]);
            }
        }
        
        Collections.sort(answer, (o1,o2)-> {
            return o1[k]-o2[k];
        });
        
        return answer;
    }
}