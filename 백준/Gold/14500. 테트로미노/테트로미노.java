import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, max;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visit[i][j] = false;
				special(i, j);
			}
		}
		
		System.out.println(max);
	}
	
	static void dfs(int x, int y ,int cnt, int state) {
		if (cnt == 4) {
			max = Math.max(max, state);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (!visit[nx][ny]) {
					visit[nx][ny] = true;
					dfs(nx, ny, cnt+1, state+map[nx][ny]);
					visit[nx][ny] = false;
				}
			}
		}
	}
	
	static void special(int x, int y) {
		int mMax = 0;
		
		if (x == 0 && y > 0 && y < m-1) {
			mMax = map[x][y] + map[x][y-1] + map[x][y+1] + map[x+1][y];
		}
		
		if (x == n-1 && y > 0 && y < m-1) {
			mMax = map[x][y] + map[x][y-1] + map[x][y+1] + map[x-1][y];
			
		}
		
		if (y == 0 && x > 0 && x < n-1) {
			mMax = map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y+1];
		}
		
		if (y == m-1 && x > 0 && x < n-1) {
			mMax = map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y-1];
		}
		
		if (x > 0 && y > 0 && x < n-1 && y < m-1) {
			int a = map[x][y] + map[x][y-1] + map[x][y+1] + map[x+1][y];
			int b = map[x][y] + map[x][y-1] + map[x][y+1] + map[x-1][y];
			int c = map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y+1];
			int d = map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y-1];
			
			int mmMax = Math.max(a, b);
			int mnMax = Math.max(c, d);
			
			mMax = Math.max(mnMax, mmMax);
		}
		
		max = Math.max(max, mMax);
	}

}
