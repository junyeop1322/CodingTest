import java.io.*;
import java.util.*;

public class Main {

	static int n, m, k, ans;
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
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			map[x][y] = 1;
		}

		ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}

		System.out.println(ans);

	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visit[x][y] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 1 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.add(new int[] {nx, ny});
						cnt++;
					}
				}
			}
		}
		
		ans = Math.max(ans, cnt);
	}

}
