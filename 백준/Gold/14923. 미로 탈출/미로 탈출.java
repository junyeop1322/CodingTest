import java.io.*;
import java.util.*;

public class Main {

	static int n, m, hx, hy, ex, ey, cnt;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		hx = Integer.parseInt(st.nextToken()) -1;
		hy = Integer.parseInt(st.nextToken()) -1;
		
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken()) -1;
		ey = Integer.parseInt(st.nextToken()) -1;
		
		map = new int[n][m];
		visit = new boolean[n][m][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		int ans = bfs(hx, hy);
		
		System.out.println(ans);
	}
	
	static int bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		int[] a = { x, y, 0, 0 };
		visit[x][y][0] = true;
		que.offer(a);

		while (!que.isEmpty()) {
			int[] b = que.poll();
			int sx = b[0];
			int sy = b[1];
			int check = b[2];
			int vis = b[3];

			if (sx == ex && sy == ey) {
				return vis;
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
		return -1;

	}

}
