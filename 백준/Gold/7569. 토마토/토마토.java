import java.io.*;
import java.util.*;

public class Main {

	static int n, m, l, ans, cnt;
	static int[][][] map;
	static int[][][] visit;
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static Queue<int[]> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new int[n][m][l];
		visit = new int[n][m][l];
		ans = 0;

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
				}
			}
		}

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k][i] == 1 && visit[j][k][i] == 0) {
						int[] a = { j, k, i };
						visit[j][k][i] = 1;
						que.offer(a);
					}
				}
			}
		}
		
		bfs();

		if (!check()) {
			ans = 0;
		} else {
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < m; k++) {
						if (visit[j][k][i] > ans) {
							ans = visit[j][k][i];
						}
					}
				}
			}
		}

//		for (int i = 0; i < l; i++) {
//			for (int j = 0; j < n; j++) {
//				for (int k = 0; k < m; k++) {
//					System.out.print(visit[j][k][i] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}

		System.out.println(ans - 1);
	}

	static void bfs() {
		while (!que.isEmpty()) {
			int[] b = que.poll();
			int sx = b[0];
			int sy = b[1];
			int sz = b[2];

			for (int i = 0; i < 6; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				int nz = sz + dz[i];

				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < l) {
					if (map[nx][ny][nz] == 0 && visit[nx][ny][nz] == 0) {
						map[nx][ny][nz] = 1;
//						for (int p = 0; p < l; p++) {
//							for (int j = 0; j < n; j++) {
//								for (int k = 0; k < m; k++) {
//									System.out.print(map[j][k][p] + " ");
//								}
//								System.out.println();
//							}
//							System.out.println();
//						}
						visit[nx][ny][nz] = visit[sx][sy][sz] + 1;
//						for (int p = 0; p < l; p++) {
//							for (int j = 0; j < n; j++) {
//								for (int k = 0; k < m; k++) {
//									System.out.print(visit[j][k][p] + " ");
//								}
//								System.out.println();
//							}
//							System.out.println();
//						}
						int[] c = { nx, ny, nz };
						que.offer(c);
					}
				}
			}

		}
//		for (int p = 0; p < l; p++) {
//			for (int j = 0; j < n; j++) {
//				for (int k = 0; k < m; k++) {
//					System.out.print(visit[j][k][p] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
	}

	static boolean check() {

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k][i] == 0) {
						return false;
					}
				}
			}
		}

		return true;
	}
}