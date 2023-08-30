import java.io.*;
import java.util.*;

public class Main {

	static int n, m, k;
	static int[][] map;
	static boolean[][][] visit;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] kx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] ky = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m][k+1]; // 0일때 점프 횟수없음, 1일때 점프 횟수 있음
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		System.out.println(bfs(0, 0));
		
	}

	static int bfs(int x, int y) { // 점프횟수 없을때, 점프횟수 있는데 마지막일때, 점프횟수 쓰고도 남을때
		Queue<int[]> q = new LinkedList<>();
		int[] a = {x, y, 0, 0};
		visit[x][y][0] = true;
		q.add(a);
		
		while(!q.isEmpty()) {
			int[] b = q.poll();
			int sx = b[0];
			int sy = b[1];
			int sc = b[2];
			int move = b[3];
			
			if (sx == n-1 && sy == m-1) {
				return move;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (!visit[nx][ny][sc] && map[nx][ny] != 1) {
						visit[nx][ny][sc] = true;
						q.add(new int[] {nx, ny, sc, move+1});
					}
				}
			}
			
			if (sc < k) {
				for (int i = 0; i < 8; i++) {
					int nx = sx + kx[i];
					int ny = sy + ky[i];
					if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
						if (!visit[nx][ny][sc+1] && map[nx][ny] != 1) {
							visit[nx][ny][sc+1] = true;
							q.add(new int[] {nx, ny, sc+1, move+1});
						}
					}
					
				}
			}
			
		}
		return -1;
		
	}
	
}
