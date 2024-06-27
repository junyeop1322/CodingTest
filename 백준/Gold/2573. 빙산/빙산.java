import java.io.*;
import java.util.*;

public class Main {

	static int n, m, cnt;
	static int[][] map;
	static int[][] map2;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

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

		int ans = 0;

		while (true) {
			cnt = 0;

			if (check()) {
				visit = new boolean[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (map[i][j] != 0 && !visit[i][j]) {
							dfs(i, j);
							cnt++;
						}
					}
				}
			} else {
				ans = 0;
				break;
			}

			year();
			
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("************");

			if (cnt >= 2) {
				break;
			}
			ans++;
		}

		System.out.println(ans);

	}

	static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (map[nx][ny] != 0 && !visit[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}

	}

	static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					return true;
				}
			}
		}
		return false;
	}

	static int ice(int x, int y) {
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (map[nx][ny] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	static void year() {
		map2 = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					map2[i][j] = ice(i, j);
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map2[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//		System.out.println("==============");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] - map2[i][j] >= 0) {
					map[i][j] = map[i][j] - map2[i][j];
				} else {
					map[i][j] = 0;
				}
			}
		}
	}

}
