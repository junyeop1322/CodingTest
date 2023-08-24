import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] map;
	static int[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new int[n][m];
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}
		
		bfs(x, y);
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		int[] a = {x, y};
		visit[x][y] = 0;
		que.offer(a);
		
		while (!que.isEmpty()) {
			int[] b = que.poll();
			int sx = b[0];
			int sy = b[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 1 && visit[nx][ny] == 0) {
						visit[nx][ny] = visit[sx][sy] + 1;
						int[] c = {nx, ny};
						que.offer(c);
					}
				}
			}
			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && visit[i][j] == 0) {
					visit[i][j] = -1;
				}
			}
		}
	}
	
}
