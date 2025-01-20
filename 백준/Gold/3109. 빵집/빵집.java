import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static char[][] map;
	static boolean[][] visited;
	static int ans;
	static boolean chk;
	
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		ans = 0;
		
		for (int i = 0; i < n; i++) {
			chk = false;
			dfs(i, 0);
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y) {
		if (y == m-1) {
			ans++;
			chk = true;
			visited[x][y] = true;
			
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
				continue;
			}
			
			if (!visited[nx][ny] && map[nx][ny] == '.') {
				dfs(nx, ny);
				
				if (chk) {
					visited[nx][ny] = true;
					return;
				} else {
					visited[nx][ny] = true;
				}
			}
		}
		
		
	}

}
