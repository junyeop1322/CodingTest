import java.io.*;
import java.util.*;

public class Main {

	static int n, m, ans;
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
		ans = 0;
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < m; i++) {
			if (map[0][i] == 0) {
				visit = new boolean[n][m];
				bfs(0, i);
				
				if (ans != 0) {
					System.out.println("YES");
					return;
				}
			}
		}
		
		System.out.println("NO");
		
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];
			
			if (sx == n-1) {
				ans = 1;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.add(new int[] {nx, ny});
						
					}
				}
				
			}
			
		}
		
	}
}
