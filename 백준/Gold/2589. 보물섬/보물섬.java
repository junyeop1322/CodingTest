import java.io.*;
import java.util.*;

public class Main {
	static int n, m, ans;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		ans = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					visit = new boolean[n][m];
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new int[] {x, y, 0});
		int num = 0;
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];
			int cnt = a[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (!visit[nx][ny] && map[nx][ny] == 'L') {
						visit[nx][ny] = true;
						q.add(new int[] {nx, ny, cnt+1});
						num = Math.max(num, cnt+1);
					}
				}
			}
			
		}
		
		return num;
	}

}
