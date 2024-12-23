import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder convert = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; convert.length() <= t * m; i++){
            convert.append(Integer.toString(i, n));
        }
        
        for(int i = p - 1;  sb.length() < t; i += m){
            sb.append(convert.charAt(i));
        }
        
        return sb.toString().toUpperCase();
    }
}