import java.io.*;
import java.util.*;

public class Main {
	
	static int n, min, max;
	static char[][] map;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		int cnt = (map[0][0] - '0');
		
		dfs(0, 0, cnt);
		
		System.out.println(max + " " + min);
		
	}
	
	static void dfs(int x, int y, int cnt) {
//		System.out.println("x : " + x + " y : " + y + " cnt : " + cnt);
		
		if (x == n-1 && y == n-1) {
//			System.out.println(1);
			max = Math.max(max, cnt);
			min = Math.min(min, cnt);
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < n && ny < n) {
				if (map[nx][ny] == '+' || map[nx][ny] == '-' || map[nx][ny] == '*') {
					dfs(nx, ny, cnt);
				} else {
					if (map[x][y] == '+') {
						dfs(nx, ny, cnt + (map[nx][ny] - '0'));
					} else if (map[x][y] == '-') {
						dfs(nx, ny, cnt - (map[nx][ny] - '0'));
					} else if (map[x][y] == '*') {
						dfs(nx, ny, cnt * (map[nx][ny] - '0'));
					}
				}
			}
		}
		
	}

}
