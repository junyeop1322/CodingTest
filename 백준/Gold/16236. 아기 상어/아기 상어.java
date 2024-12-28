import java.io.*;
import java.util.*;

public class Main {
	
	static int n, ans, r, c;
	static int[][] map;
	
	static int size, count;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		ans = 0;
		
		r = 0;
		c = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					r = i;
					c = j;
				}
			}
		}
		
		size = 2;
		count = 0;
		
		while(true) {
			if (helpMom()) {
				break;
			}
			
			eatFish();
		}
		
		
		System.out.println(ans);
	}
	
	static void eatFish() {
		int[][] arr = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		
		int min = Integer.MAX_VALUE;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c, 1});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int cnt = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if (!visited[nx][ny] && size >= map[nx][ny]) {
					if (map[nx][ny] != 0 && size > map[nx][ny]) {
						arr[nx][ny] = cnt;
						min = Math.min(min, cnt);
					}
					
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny, cnt+1});
					
				}
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == min) {
					ans += arr[i][j];
					
					map[i][j] = 9;
					map[r][c] = 0;
					
					r = i;
					c = j;
					count++;
					
					if (count == size) {
						size++;
						count = 0;
					}
					
					return;
				}
			}
		}
	}
	
	static boolean helpMom() {
		boolean chk = true;
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == r && j == c) {
					continue;
				}
				
				if (map[i][j] != 0 && map[i][j] < size) {
					chk = false;
					break;
				}
			}
			
			if (!chk) {
				break;
			}
		}
		
		if (!chk) {
			chk = true;
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];
			visited[r][c] = true;
			
			q.add(new int[] {r, c});
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
						continue;
					}
					
					if (!visited[nx][ny] && map[nx][ny] <= size) {
						if (map[nx][ny] != 0 && map[nx][ny] < size) {
							return false;
						}
						
						visited[nx][ny] = true;
						q.add(new int[] {nx, ny});
					}
				}
			}
			
		}
		
		return chk;
	}

}
