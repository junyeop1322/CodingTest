import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        Arrays.sort(mats);
        int idx = mats.length - 1;
        
        while(idx >= 0) {
            if (checkPark(park, mats[idx])) {
                answer = mats[idx];
                break;
            }
            
            idx--;
        }
        
        return answer;
    }
    
    static boolean checkPark(String[][] park, int num) {
        boolean chk = false;
        int n = park.length;
        int m = park[0].length;
        
        for (int i = 0; i <= n-num; i++) {
            for (int j = 0; j <= m-num; j++) {
                boolean ch = true;
                for (int r = i; r < i + num; r++) {
                    for (int c = j; c < j + num; c++) {
                        if (!park[r][c].equals("-1")) {
                            ch = false;
                            break;
                        }
                    }
                    
                    if (!ch) {
                        break;
                    }
                }
                if (ch) {
                    return true;
                }
            }
        }
        
        
        return chk;
    }
}