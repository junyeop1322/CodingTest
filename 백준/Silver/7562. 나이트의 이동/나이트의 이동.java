import java.util.*;
import java.io.*;

public class Main {
	
	static int n, num;
	static int[][] map;
	
	static int r, c;
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1}; // 시계방향
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] ans = new int[T];
		
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			num = 0;
			bfs(x, y);
			
			ans[t] = num-1;
		}
		
		for (int t = 0; t < T; t++) {
			System.out.println(ans[t]);
		}
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		int[] a = {x ,y};
		map[x][y] = 1;
		que.offer(a);
		
		while(true) {
			int[] b = que.poll();
			int sx = b[0];
			int sy = b[1];
			
			for (int i = 0; i < 8; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
			
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = map[sx][sy] + 1;
						int[] c = {nx, ny};
						que.offer(c);
					}
					
					if (nx == r && ny == c) {
						num = map[nx][ny];
						return;
					}
					
				}
			}
			
		}
	}

}
