import java.util.*;

class Solution {
    
    static int n, m, r, c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        n = park.length;
        m = park[0].length();
        
        r = 0;
        c = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            move(park, routes[i]);
        }
        
        answer[0] = r;
        answer[1] = c;
        
        return answer;
    }
    
    static void move(String[] park, String route) {
        char order = route.charAt(0);
        int cnt = route.charAt(2) - '0';
        int o = 0;
        
        if (order == 'N') {
            o = 0;
        } else if (order == 'S') {
            o = 1;
        } else if (order == 'W') {
            o = 2;
        } else if (order == 'E') {
            o = 3;
        }
        
        int sx = r;
        int sy = c;
        boolean check = true;
        
        for (int i = 0; i < cnt; i++) {
            int nr = sx + dx[o];
            int nc = sy + dy[o];
            
            if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                if (park[nr].charAt(nc) != 'X') {
                    sx = nr;
                    sy = nc;
                } else {
                    check = false;
                    break;
                }
            } else {
                check = false;
                break;
            }
        }
        
        if (check) {
            r = sx;
            c = sy;
        }
    }
}