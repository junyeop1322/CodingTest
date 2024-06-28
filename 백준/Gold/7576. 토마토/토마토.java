import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0 ,0, -1 ,1};
	
	static Queue<int[]> q = new LinkedList<>(); 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new int[] {i, j});
				}
			}
		}
		
		bfs();
		
		int max = Integer.MIN_VALUE;
		
		if (!check()) {
			System.out.println(-1);;
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			
			System.out.println(max - 1);
		}
		
		
		

	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int x = a[0];
			int y = a[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = map[x][y] + 1;
						q.add(new int[] {nx, ny});
						
					}
					
				}
				
			}
			
		}
		
	}
	
	static boolean check() {
		
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}

}
