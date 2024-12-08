import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] arr = new int[y+1];
        Arrays.fill(arr, -1);
        
        arr[x] = 0;
        
        for (int i = x; i <= y; i++) {
            if (arr[i] == -1) {
                continue;
            }
            
            if (i+n <= y) {
                if (arr[i+n] == -1) {
                    arr[i+n] = arr[i]+1;
                } else {
                    arr[i+n] = Math.min(arr[i+n], arr[i]+1);
                }
            }
            if (i*2 <= y) {
                if (arr[i*2] == -1) {
                    arr[i*2] = arr[i]+1;
                } else {
                    arr[i*2] = Math.min(arr[i*2], arr[i]+1);
                }
            }
            if (i*3 <= y) {
                if (arr[i*3] == -1) {
                    arr[i*3] = arr[i]+1;
                } else {
                    arr[i*3] = Math.min(arr[i*3], arr[i]+1);
                }
            }
        }
        
        return arr[y];
    }
}