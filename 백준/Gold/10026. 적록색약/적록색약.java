import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] map;
	static boolean[][] visited;
	
	static int n;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		int a = 0;
		int b = 0;
		
		map = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					dfs1(i, j);
					a++;
				}
			}
		}
		
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					dfs2(i, j);
					b++;
				}
			}
		}
	
		System.out.printf("%d %d", a, b);
		
	}
	
	static void dfs1(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] == map[x][y] && !visited[nx][ny]) {
					dfs1(nx, ny);
				}
			}
			
		}
		
	}

	
	static void dfs2(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[x][y] == 'R' || map[x][y] == 'G') {
					if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
						if (!visited[nx][ny]) {
							dfs2(nx, ny);
						}
					}
				} else if (map[nx][ny] == map[x][y] && !visited[nx][ny]) {
					dfs2(nx, ny);
				}
			}
			
		}
		
		
	}
}
