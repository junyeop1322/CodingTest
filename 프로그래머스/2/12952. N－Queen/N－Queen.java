import java.util.*;

class Solution {
    
    static int ans;
    static int[] arr;
    
    public int solution(int n) {
        ans = 0;
        arr = new int[n];
        
        getQueen(0);
        
        return ans;
    }
    
    static void getQueen(int num) {
        if (num == arr.length) {
            ans++;
            return;
        }
        
        for (int i = 1; i <= arr.length; i++) {
            arr[num] = i;
            if (check(num)) {
               getQueen(num+1); 
            }
        }
        
    }
    
    static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }
            
            if (Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
                return false;
            }
        }
        
        
        return true;
    } 
}