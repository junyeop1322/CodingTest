import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int hole = -99;
	static int max = -1;
	static boolean flag = false;
	static int[][] map, dp;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'H') {
					map[i][j] = hole;
				} else {
					map[i][j] = str.charAt(j) - '0';
				}
			}
		}
		
		visited[0][0] = true;
		dfs(0, 0, 1);
		
		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(max);
		}
	}
	
	static void dfs(int x, int y , int cnt) {
		if (cnt > max) {
			max = cnt;
		}
		
		dp[x][y] = cnt;
		
		for (int i = 0; i < 4; i++) {
			int cur = map[x][y];
			int nx = x + (cur * dx[i]);
			int ny = y + (cur * dy[i]);
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == hole) {
				continue;
			}
			
			if (visited[nx][ny]) {
				flag = true;
				return;
			}
			
			if (dp[nx][ny] > cnt) {
				continue;
			}
			
			visited[nx][ny] = true;
			dfs(nx, ny, cnt+1);
			visited[nx][ny] = false;
		}
	}

}
