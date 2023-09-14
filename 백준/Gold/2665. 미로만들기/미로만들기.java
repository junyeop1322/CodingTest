import java.io.*;
import java.util.*;

public class Main {

	static int n, min;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dik;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visit = new boolean[n][n];
		dik = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dik[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
		
		if (map[0][0] == 0) {
			dik[0][0] = 1;
		} else {
			dik[0][0] = 0;
		}
		
		bfs();
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(dik[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(dik[n-1][n-1]);
		
		
//		min = Integer.MAX_VALUE;
//		dfs(0, 0, 0);
//		System.out.println(min);
	}
	
	static void dfs(int x, int y, int cnt) {
		
		if (cnt > min) {
			return;
		}
		
		if (x == n-1 && y == n-1) {
			min = Math.min(min, cnt);
			return;
		}
		
		if (map[x][y] == 0) {
			cnt++;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (!visit[nx][ny]) {
					visit[nx][ny] = true;
					dfs(nx, ny, cnt);
					visit[nx][ny] = false;
				}
			}
		}
	}
	
	static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		q.add(new int[] {0, 0, dik[0][0]});
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];
			
			if (sx == n-1 && sy == n-1) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				int ans = 0;
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] == 0) {
						ans = 1;
					}
					
					if (dik[nx][ny] > a[2] + ans) {
						dik[nx][ny] = a[2] + ans;
						q.add(new int[] {nx, ny, dik[nx][ny]});
					}
				}
				
			}
			
		}
		
	}

}
