import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map;
	static int n;
	static int max = Integer.MIN_VALUE;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int rain = 0; rain <= 100; rain++) {
			check = new boolean[n][n];
			int cnt = 0;
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					if (map[x][y] > rain && check[x][y] == false) {
						dfs(x, y, rain);
						cnt++;
					}
				}
			}
			
			if (cnt > max) {
				max = cnt;
			}
		}
		
		System.out.println(max);
	}

	static void dfs(int x, int y, int rain) {
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] > rain && check[nx][ny] == false) {
					dfs(nx, ny, rain);
				}
			}
		}
	}
}
