import java.io.*;
import java.util.*;

public class Main {

	static int n, m, ans;
	static int[][] map;
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
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;

		dfs(0);

		System.out.println(ans);
	}

	static void dfs(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wall + 1);
					map[i][j] = 0;
				}
			}
		}

	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			copy[i] = map[i].clone();
		}

		while (!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];

			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (copy[nx][ny] == 0) {
						copy[nx][ny] = 2;
						q.add(new int[] { nx, ny });
					}
				}
			}

		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copy[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		ans = Math.max(ans, cnt);

	}

}
