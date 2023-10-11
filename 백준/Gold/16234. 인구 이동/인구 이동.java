import java.io.*;
import java.util.*;

public class Main {

	static int n, L, R, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;

		while (true) {
			boolean check = false;
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						int sum = bfs(i, j);
						if (list.size() > 1) {
							check = true;
							int avg = sum / list.size();
							for (int k = 0; k < list.size(); k++) {
								map[list.get(k)[0]][list.get(k)[1]] = avg;
							}
						}
					}
				}
			}
			
			if (!check) {
				break;
			}
			
			ans++;
		}
		
		System.out.println(ans);

	}

	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		list = new ArrayList<>();

		q.add(new int[] { x, y });
		list.add(new int[] { x, y });
		visit[x][y] = true;

		int sum = map[x][y];

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int sx = arr[0];
			int sy = arr[1];

			for (int d = 0; d < 4; d++) {
				int nx = sx + dx[d];
				int ny = sy + dy[d];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
					int num = Math.abs(map[sx][sy] - map[nx][ny]);
					if (num >= L && num <= R) {
						q.add(new int[] {nx, ny});
						list.add(new int[] {nx, ny});
						visit[nx][ny] = true;
						sum += map[nx][ny];
					}
				}
			}

		}

		return sum;
	}


}
