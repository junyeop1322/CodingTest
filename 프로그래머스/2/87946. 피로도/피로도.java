class Solution {
    
    static int ans, n;
    
    public int solution(int k, int[][] dungeons) {
        ans = -1;
        n = dungeons.length;
        
        int hp = k;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (dungeons[i][0] <= hp) {
                visited[i] = true;
                dun(visited, dungeons, hp - dungeons[i][1], 1);
                visited[i] = false;
            }
        }
        
        return ans;
    }
    
    static void dun(boolean[] visited, int[][] dungeons, int hp, int cnt) {
        if (ans == n) {
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && hp >= dungeons[i][0]) {
                visited[i] = true;
                dun(visited, dungeons, hp-dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
        // System.out.println("hp : " + hp + ", cnt : " + cnt);
        
        ans = Math.max(ans, cnt);
        
    }
}