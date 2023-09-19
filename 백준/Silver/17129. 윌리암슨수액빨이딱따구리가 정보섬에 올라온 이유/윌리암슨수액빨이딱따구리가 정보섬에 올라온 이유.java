import java.io.*;
import java.util.*;

public class Main {

	static int n, m, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
				
				if (map[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}
		
		ans = 0;
		bfs(x, y);
		
		if (ans == 0) {
			System.out.println("NIE");
		} else {
			System.out.println("TAK");
			System.out.println(ans);	
		}		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new int[] {x, y, 0});
		
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];
			int sCnt = a[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] != 1 && !visit[nx][ny]) {
						if (map[nx][ny] == 0) {
							visit[nx][ny] = true;
							q.add(new int[] {nx, ny, sCnt+1});
						} else {
							ans = sCnt+1;
							return;
						}
					}
				}
			}
			
		}
		
	}

}
