import java.io.*;
import java.util.*;

public class Main {

	static int n, m, k, cnt;
	static char[][][] map;
	static boolean[][][] visit;
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (k == 0 && n == 0 && m == 0) {
				break;
			}

			map = new char[k][n][m];
			visit = new boolean[k][n][m];

			for (int l = 0; l < k; l++) {
				for (int i = 0; i < n; i++) {
					String str = br.readLine();
					for (int j = 0; j < m; j++) {
						map[l][i][j] = str.charAt(j);
					}
				}
				br.readLine();
			}
			cnt = 0;
			for (int l = 0; l < k; l++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (map[l][i][j] == 'S') {
							bfs(l, i, j);
						}
					}
				}
			}

			if (cnt == -1) {
				sb.append("Trapped!").append("\n");
			} else {
				sb.append("Escaped in " + cnt + " minute(s).").append("\n");
			}

		}

		System.out.println(sb);
	}

	static void bfs(int z, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visit[z][x][y] = true;
		q.add(new int[] { z, x, y, 0 });

		while (!q.isEmpty()) {
			int[] a = q.poll();
			int sz = a[0];
			int sx = a[1];
			int sy = a[2];
			int sCnt = a[3];

			for (int i = 0; i < 6; i++) {
				int nz = sz + dz[i];
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nz >= 0 && nx >= 0 && ny >= 0 && nz < k && nx < n && ny < m) {
					if (map[nz][nx][ny] == '.' && !visit[nz][nx][ny]) {
						visit[nz][nx][ny] = true;
						q.add(new int[] { nz, nx, ny, sCnt + 1 });
					}
					if (map[nz][nx][ny] == 'E') {
						cnt = sCnt + 1;
						return;
					}

				}
			}
		}

		cnt = -1;
	}

}
