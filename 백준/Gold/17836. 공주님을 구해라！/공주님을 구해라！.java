import java.io.*;
import java.util.*;

class Main {

	static int n, m, t, ans;
	static int[][] map;
	static boolean[][] visit;
	static boolean[][] visitG;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visit = new boolean[n][m];
		visitG = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		
		bfs(0, 0, 0, t);
		
		if (ans == Integer.MAX_VALUE) {
			System.out.println("Fail");
		} else {
			System.out.println(ans);
		}
		
	}
	
	static void bfs(int x, int y, int cnt, int time) {
		Queue<int[]> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new int[] {x, y, cnt, time});
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];
			int sCnt = a[2];
			int tt = a[3];
			
			if (sx == n-1 && sy == m-1) {
				ans = Math.min(ans, sCnt);
				return;
			}
			
			if (tt == 0) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.add(new int[] {nx, ny, sCnt+1, tt-1});
					}
					if (map[nx][ny] == 2 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						gram(nx, ny, sCnt+1, tt-1);
					}
				}
				
			}
			
		}
		
		
	}
	
	static void gram(int x, int y, int cnt, int time) {
		Queue<int[]> q = new LinkedList<>();
		visitG[x][y] = true;
		q.add(new int[] {x, y, cnt, time});
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];
			int sCnt = a[2];
			int tt = a[3];
			
			if (sx == n-1 && sy == m-1) {
				ans = Math.min(ans, sCnt);
				return;
			}
			
			if (tt == 0) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (!visitG[nx][ny]) {
						visitG[nx][ny] = true;
						q.add(new int[] {nx, ny, sCnt+1, tt-1});
					}
				}
				
			}
		}
	}

}
