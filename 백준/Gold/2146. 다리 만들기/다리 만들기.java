import java.io.*;
import java.util.*;

public class Main {

	static int n, min;
	static int[][] map;
	static boolean[][] visit;
	static boolean[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	// 우선 섬 하나 탐색 -> 섬은 다 false로 만듬 -> 섬에서 사방탐색 후 0인곳을 찾음
	// 이 섬이 아닌 다른 섬으로 탐색 짧은 거리 찾기
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		check = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		land();
		
		min = Integer.MAX_VALUE;
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0 && check(i, j)) {
//					System.out.println(i + " ==== " + j);
					bridge(i, j, map[i][j]);
				}
			}
		}
		
		System.out.println(min);
		
	}
	
	static boolean check(int x, int y) {
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean checkB(int x, int y, int num) {
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] != 0 && map[nx][ny] != num) {
					return true;
				}
			}
		}
		return false;
	}
	
	static void bridge(int x, int y, int num) {
		visit = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new int[] {x, y, 0});
		
		while(!q.isEmpty()) {
			int[] b = q.poll();
			int sx = b[0];
			int sy = b[1];
			int cnt = b[2];
			
			if (checkB(sx, sy, num)) {
//				System.out.println(cnt);
//				System.out.println("----------");
				min = Math.min(min, cnt);
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (map[nx][ny] == 0 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.add(new int[] {nx, ny, cnt+1});
					} 
				}
			}
			
		}
		
		
	}
	
	static void land() {
		int idx = 2;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !check[i][j]) {
					Queue<int[]> q = new LinkedList<>();
					check[i][j] = true;
					map[i][j] = idx;
					q.add(new int[] {i, j});
					
					while(!q.isEmpty()) {
						int[] b = q.poll();
						
						int x = b[0];
						int y = b[1];
						
						for (int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							
							if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
								if (map[nx][ny] == 1 && !check[nx][ny]) {
									map[nx][ny] = idx;
									check[nx][ny] = true;
									q.add(new int[] {nx, ny});
								}
							}
						}
					}
					idx++;
				}
			}
		}
	}
}
