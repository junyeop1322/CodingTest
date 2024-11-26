import java.util.*;

class Solution {
    
    static Character[][] map;
    
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        map = new Character[wallpaper.length][wallpaper[0].length()];
        
        int n = map.length;
        int m = map[0].length;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                map[i][j] = wallpaper[i].charAt(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            boolean check = false;
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '#') {
                    check = true;
                    break;
                }
            }
            
            if (check) {
                answer[0] = i;
                break;
            }
        }
        
        for (int j = 0; j < m; j++) {
            boolean check = false;
            for (int i = 0; i < n; i++) {
                if (map[i][j] == '#') {
                    check = true;
                    break;
                }
            }
            
            if (check) {
                answer[1] = j;
                break;
            }
        }
        
        for (int i = n-1; i >= 0; i--) {
            boolean check = false;
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '#') {
                    check = true;
                    break;
                }
            }
            
            if (check) {
                answer[2] = i+1;
                break;
            }
        }
        
        for (int j = m-1; j >= 0; j--) {
            boolean check = false;
            for (int i = 0; i < n; i++) {
                if (map[i][j] == '#') {
                    check = true;
                    break;
                }
            }
            
            if (check) {
                answer[3] = j+1;
                break;
            }
        }
        
        return answer;
    }
}