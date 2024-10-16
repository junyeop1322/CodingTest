import java.util.*;

class Solution {
    
    static int min;
    static int max;
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getRockCount(distance, rocks, mid) <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    static int getRockCount(int dist, int[] rocks, int n) {
        int start = 0;
        int end = dist;
        
        int cnt = 0;
        
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - start < n) {
                cnt++;
                continue;
            }
            
            start = rocks[i];
        }
        
        if (end - start < n) {
            cnt++;
        }
        
        return cnt;
    }
}