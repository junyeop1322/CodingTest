import java.util.*;
import java.io.*;

public class Main {

	static int n, cntG, cntR, cntB, cntRG;
	static char[][] map;
	static boolean[][] visit;
	static boolean[][] visitRG;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		visit = new boolean[n][n];
		visitRG = new boolean[n][n];

		cntG = 0;
		cntR = 0;
		cntB = 0;
		cntRG = 0;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'B' && !visit[i][j] && !visitRG[i][j]) {
					bfsB(i, j);
					cntB++;
//					System.out.println(0);
				}
				if (map[i][j] == 'G' && !visit[i][j]) {
					bfsG(i, j);
					cntG++;
//					System.out.println(1);
				}
				if (map[i][j] == 'R' && !visit[i][j]) {
					bfsR(i, j);
					cntR++;
//					System.out.println(2);
				}
				if (map[i][j] == 'R' || map[i][j] == 'G') {
					if (!visitRG[i][j]) {
						bfsRG(i, j);
						cntRG++;
//						System.out.println(3);
					}
				}
			}
		}
		
		int ans1 = cntG + cntR + cntB;
		int ans2 = cntRG + cntB;
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
//		System.out.println(cntB + " " + cntRG + " " + cntR + " " + cntG);
		
		System.out.println(ans1 + " " + ans2);

	}

	static void bfsB(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		visit[x][y] = true;
		visitRG[x][y] = true;
		int[] a = { x, y };
		que.offer(a);

		while (!que.isEmpty()) {
			int[] b = que.poll();
			int sx = b[0];
			int sy = b[1];

			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] == 'B' && !visit[nx][ny] && !visitRG[nx][ny]) {
						visit[nx][ny] = true;
						visitRG[nx][ny] = true;

						int[] c = { nx, ny };
						que.offer(c);
					}
				}

			}
		}

	}

	static void bfsG(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		visit[x][y] = true;
		int[] a = { x, y };
		que.offer(a);

		while (!que.isEmpty()) {
			int[] b = que.poll();
			int sx = b[0];
			int sy = b[1];

			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] == 'G' && !visit[nx][ny]) {
						visit[nx][ny] = true;

						int[] c = { nx, ny };
						que.offer(c);
					}
				}

			}
		}

	}

	static void bfsR(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		visit[x][y] = true;
		int[] a = { x, y };
		que.offer(a);

		while (!que.isEmpty()) {
			int[] b = que.poll();
			int sx = b[0];
			int sy = b[1];

			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] == 'R' && !visit[nx][ny]) {
						visit[nx][ny] = true;

						int[] c = { nx, ny };
						que.offer(c);
					}
				}

			}
		}

	}

	static void bfsRG(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		visitRG[x][y] = true;
		int[] a = { x, y };
		que.offer(a);

		while (!que.isEmpty()) {
			int[] b = que.poll();
			int sx = b[0];
			int sy = b[1];

			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
						if (!visitRG[nx][ny]) {
							visitRG[nx][ny] = true;

							int[] c = { nx, ny };
							que.offer(c);
						}
					}
				}

			}
		}

	}

}
