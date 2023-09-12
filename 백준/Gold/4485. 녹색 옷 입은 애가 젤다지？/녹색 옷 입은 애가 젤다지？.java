import java.io.*;
import java.util.*;

public class Main {

	static int n, m, cnt, ans;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		cnt = 1;

		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			map = new int[n][n];
			dp = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			visit = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][0] = map[0][0];
			bfs(0, 0, dp[0][0]);
//			ans = Integer.MAX_VALUE;
//			visit[0][0] = true;
//			dfs(0, 0, map[0][0]);

			ans = dp[n - 1][n - 1];
			sb.append("Problem " + cnt + ": " + ans).append("\n");
			cnt++;
		}

		System.out.println(sb);
	}

	static void dfs(int x, int y, int state) {

		if (state >= ans) {
			return;
		}

//		System.out.println("x : " + x + " y : " + y);

		if (x == n - 1 && y == n - 1) {
			System.out.println(state);
			ans = Math.min(ans, state);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (!visit[nx][ny]) {
					visit[nx][ny] = true;
					dfs(nx, ny, state + map[nx][ny]);
					visit[nx][ny] = false;
				}

			}
		}

	}

	static void bfs(int x, int y, int state) {

		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
		q.offer(new int[] { x, y, state });

		while (!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];

			if (dp[sx][sy] < a[2])
				continue;

			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (dp[nx][ny] > a[2] + map[nx][ny]) {
						dp[nx][ny] = a[2] + map[nx][ny];

						q.offer(new int[] { nx, ny, dp[nx][ny] });

					}
				}
			}

		}

	}

}
