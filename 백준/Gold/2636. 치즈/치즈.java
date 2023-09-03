import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, cnt;
	static int[][] map;
	static int[][] check;
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
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 1;
		while(true) {
			cnt = 0;
			check = new int[n][m];
			visit = new boolean[n][m];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						cnt++;
					}
				}
			}
			
			bfs();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (check[i][j] != 0) {
						map[i][j] = 0;
					}
				}
			}
			
			if (find()) {
				System.out.println(year);
				System.out.println(cnt);
				break;
			}
			year++;
		}
		
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visit[0][0] = true;
		q.add(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int x = a[0];
			int y = a[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.add(new int[] {nx, ny});
					}
					if (map[nx][ny] == 1) {
						check[nx][ny] = 1;
					}
				}
			}
		}
	}

	static boolean find() {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
}
