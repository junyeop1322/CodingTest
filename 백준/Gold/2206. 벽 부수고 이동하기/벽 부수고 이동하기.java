import java.util.*;
import java.io.*;

public class Main {

	static int n, m, cnt;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visit = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		cnt = -1;
		bfs(0, 0);

		System.out.println(cnt);
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		int[] a = { x, y, 0, 1 };
		visit[x][y][0] = true;
		que.offer(a);

		while (!que.isEmpty()) {
			int[] b = que.poll();
			int sx = b[0];
			int sy = b[1];
			int check = b[2];
			int vis = b[3];

			if (sx == (n - 1) && sy == (m - 1)) {
				cnt = vis;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
//				System.out.println(nx + " " + ny);

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0) { // 다음이 0
						if (!visit[nx][ny][0] && check == 0) { // 다음이 방문 x 나도 부순적 없음
							visit[nx][ny][0] = true;
//							map[nx][ny] = 2;
							int[] c = { nx, ny, check, vis + 1 };
							que.offer(c);
//							System.out.println(c[3]);

						}
						if (!visit[nx][ny][1] && check == 1) {
							visit[nx][ny][1] = true;
//							map[nx][ny] = 2;
							int[] c = { nx, ny, check, vis + 1 };
							que.offer(c);
//							System.out.println(c[3]);
						}
					}
					if (map[nx][ny] == 1 && check == 0 && !visit[nx][ny][0]) { // 다음이 1 그리고 나는 아직 안부쉈음
//						System.out.println(nx + " " + ny);
						int newCheck = 1;
						visit[nx][ny][0] = true;
//						map[nx][ny] = 2;
						int[] c = { nx, ny, newCheck, vis + 1 };
						que.offer(c);
//						System.out.println(c[3]);
					}
				}
			}
		}

	}
}
