import java.io.*;
import java.util.*;

public class Main {

	static int n, m, cnt, cnt2;
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
		
		cnt = 0;
		int max = 0;
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					max = Math.max(max, bfs(i, j));
					cnt++;
				}
			}
		}
		
	
		
		System.out.println(cnt);
		System.out.println(max);
	}


	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visit[x][y] = true;
		cnt2 = 1;
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] b = q.poll();
			int sx = b[0];
			int sy = b[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 1 && !visit[nx][ny]) {
						q.add(new int[] {nx, ny});
						visit[nx][ny] = true;
						cnt2++;
					}
				}
			}
		}
		return cnt2;
	}
	
}
