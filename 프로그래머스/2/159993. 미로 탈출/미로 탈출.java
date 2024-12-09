import java.util.*;

class Solution {
    
    static Character[][] arr;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int n, m, ans;
    
    public int solution(String[] maps) {
        ans = 0;
        n = maps.length;
        m = maps[0].length();
        
        arr = new Character[n][m];
        
        int sx = 0;
        int sy = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = maps[i].charAt(j);
                
                if (arr[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }
        
        findLever(sx, sy);
        
        return ans;
    }
    
    static void findLever(int x, int y) {
        visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int sx = cur[0];
            int sy = cur[1];
            int cnt = cur[2];
            
            if (arr[sx][sy] == 'L') {
                ans += cnt;
                findExit(sx, sy);
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                if (!visited[nx][ny] && arr[nx][ny] != 'X') {
                    q.add(new int[]{nx, ny, cnt+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        ans = -1;
        return;
    }
    
    static void findExit(int x, int y) {
        visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int sx = cur[0];
            int sy = cur[1];
            int cnt = cur[2];
            
            if (arr[sx][sy] == 'E') {
                ans += cnt;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                if (!visited[nx][ny] && arr[nx][ny] != 'X') {
                    q.add(new int[]{nx, ny, cnt+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        ans = -1;
        return;
    }
}