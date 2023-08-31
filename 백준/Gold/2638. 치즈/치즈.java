import java.io.*;
import java.util.*;

public class Main {

	static int n, m, cnt;
	static int[][] map;
	static boolean[][] check;
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
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while(true) {
//			System.out.println(1);
			visit = new int[n][m];
			check = new boolean[n][m];
			
//			System.out.println(2);
			if (check()) {
//				System.out.println(4);
				break;
			}
//			System.out.println(3);
			bfs();
			
			for(int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visit[i][j] >= 2) {
						map[i][j] = 0;
					}
				}
			}
			cnt++;
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(n + " " + m);
		
		System.out.println(cnt);
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		check[0][0] = true;
		q.add(new int[] {0, 0});
		
		while (!q.isEmpty()) {
			int[] b = q.poll();
			int x = b[0];
			int y = b[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0 && !check[nx][ny]) {
						check[nx][ny] = true;
						q.add(new int[] {nx, ny});
					}
					if (map[nx][ny] == 1) {
						visit[nx][ny]++;
					}
				}
			}
			
		}
		
	}

	static boolean check() { // 치즈가 녹았는지 확인하는 함수
		
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
