import java.io.*;
import java.util.*;

public class Main {

	static int n, m, ans, cnt;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[12][6];

		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		ans = 0;

		puyo();

		System.out.println(ans);

	}

	static void puyo() {

		while (true) {
			boolean flag = true;
			visit = new boolean[12][6];

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						list = new ArrayList<>();
						bfs(i, j, map[i][j]);

						if (list.size() >= 4) {
							flag = false;
							for (int k = 0; k < list.size(); k++) {
								map[list.get(k)[0]][list.get(k)[1]] = '.';
							}
						}

					}
				}
			}

			if (flag) {
				break;
			}

			drop();
			ans++;
		}

	}

	static void bfs(int x, int y, char c) {
		Queue<int[]> q = new LinkedList<>();
		list.add(new int[] { x, y });
		q.add(new int[] { x, y });
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];

			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6) {
					if (map[nx][ny] == c && !visit[nx][ny]) {
						visit[nx][ny] = true;
						list.add(new int[] { nx, ny });
						q.add(new int[] { nx, ny });
					}
				}
			}
		}
	}

	static void drop() {
		for (int j = 0; j < 6; j++) {
			for (int i = 11; i > 0; i--) {
				if (map[i][j] == '.') {
					for (int k = i - 1; k >= 0; k--) {
						if (map[k][j] != '.') {
							map[i][j] = map[k][j];
							map[k][j] = '.';
							break;
						}
					}
				}
			}
		}
	}

}
