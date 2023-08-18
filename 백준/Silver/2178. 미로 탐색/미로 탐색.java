import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] map;
	static int[][] visit;
	static int[] dr = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = (int) (s.charAt(j) - '0');
			}
		}

		bfs(0, 0);

	}

	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		int[] arr = {x, y};
		visit[x][y] = 1;
		que.offer(arr);
		
		while (true) {
			int[] a = que.poll();
			int r = a[0];
			int c = a[1];
			
			if (r == n-1 && c == m-1) {
				System.out.println(visit[r][c]);
				break;
			}
			
			
			for (int i = 0; i < 4; i++) {
				
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
					if (map[nr][nc] == 1 && visit[nr][nc] == 0) {
						int[] b = {nr, nc};
						visit[nr][nc] = visit[r][c] + 1;
						que.offer(b);
					}
				}
			}
			
		}
	}

}
