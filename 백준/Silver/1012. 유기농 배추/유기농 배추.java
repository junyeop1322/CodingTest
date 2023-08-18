import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, k;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] ans = new int[T];
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			visit = new boolean[n][m];
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1 && visit[i][j] == false) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			ans[t] = cnt;
			
		}
		
		for (int t = 0; t < T; t++) {
			System.out.println(ans[t]);
		}
	}

	static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (!visit[nx][ny] && map[nx][ny] == 1) {
					dfs(nx, ny);
				}
			}
		}
	}
	
}
