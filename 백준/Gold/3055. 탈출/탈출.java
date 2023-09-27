import java.io.*;
import java.util.*;

public class Main {

	static int n, m, cnt;
	static char[][] map;
	static int[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int r = 0;
		int c = 0;

		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'S') {
					r = i;
					c = j;
				}
			}
		}

		int ans = 0;
		cnt = 0;
		while (!check()) {
			escape();
			water();
			
			if (cnt == 1) {
				System.out.println(ans+1);
				return;
			}
			
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("**********");

			ans++;
		}


		System.out.println("KAKTUS");

	}

	static void escape() {
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'S') {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
							if (map[nx][ny] == '.' && visit[nx][ny] == 0) {
								visit[nx][ny] = 2;

							}
							
							if (map[nx][ny] == 'D') {
								cnt = 1;
								return;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j] == 2) {
					map[i][j] = 'S';
				}
			}
		}
	}

	static void water() {
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '*') {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
							if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
								if (visit[nx][ny] == 0) {
									visit[nx][ny] = 1;
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j] == 1) {
					map[i][j] = '*';
				}
			}
		}

	}

	static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'S') {
					return false;
				}
			}
		}

		return true;
	}

}
