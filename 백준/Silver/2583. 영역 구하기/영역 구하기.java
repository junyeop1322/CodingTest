import java.io.*;
import java.util.*;

public class Main {

	static int n, m, k, cnt, cnt2;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		cnt = 0;

		map = new int[n + 1][m + 1];
		visit = new boolean[n + 1][m + 1];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int r = y1; r < y2; r++) {
				for (int c = x1; c < x2; c++) {
					map[r][c] += 1;
				}
			}
//			for (int o = 0; o < n; o++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(map[o][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && !visit[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}

		arr = new int[cnt];
		int num = 0;
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && !visit[i][j]) {
					bfs(i, j, num);

					num--;
				}
			}
		}

		for (int i = 0; i < cnt; i++) {
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					if (map[r][c] == -i) {
						arr[i]++;
					}
				}
			}
		}
		
		Arrays.sort(arr);
		
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (map[nx][ny] == 0 && !visit[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

	static void bfs(int x, int y, int num) {
		Queue<int[]> q = new LinkedList<>();
		visit[x][y] = true;
		map[x][y] = num;
		q.add(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] b = q.poll();
			int sx = b[0];
			int sy = b[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						map[nx][ny] = num;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}

}
