import java.util.*;

class Solution {
    
    static int n, m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {        
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
            
        return bfs(maps);
    }
    
    static int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[] {0, 0, 1});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if (x == n-1 && y == m-1) {
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                
                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, cnt+1});
                }
            }
        }
        
        return -1;
    }
    
    
}