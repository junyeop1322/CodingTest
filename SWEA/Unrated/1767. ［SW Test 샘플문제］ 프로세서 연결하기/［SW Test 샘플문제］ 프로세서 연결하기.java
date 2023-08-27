import java.io.*;
import java.util.*;

public class Solution {

	static int n, core, ans;
	static int maxCore;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			core = 0;
			maxCore = 0;
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						map[i][j] = 2;
						core++;
					}
				}
			}
			
			dfs(1, 1, 0);

			if (ans == Integer.MAX_VALUE) {
				ans = 0;
			}
			
			System.out.println("#" + t + " " + ans);
		}

	}

	static void dfs(int x, int y, int cnt) {

		if (x == n - 1) {
			if (cnt > maxCore) {
				ans = Integer.MAX_VALUE;
			}
			
			if (cnt >= maxCore) {
				maxCore = cnt;

				int elec = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] == 1) {
							elec++;
						}
					}
				}

				ans = Math.min(ans, elec);
			}

			return;
		}

		if (y == n - 1) {
			dfs(x + 1, 1, cnt);
			return;
		}

		if (map[x][y] == 2) {
			for (int i = 0; i < 4; i++) {
				if (check(x, y, i)) {
					onCore(x, y, i, 1);
					dfs(x, y + 1, cnt + 1);
					onCore(x, y, i, 0);
				} 
			}
			dfs(x, y+1, cnt);
		} else {
			dfs(x, y + 1, cnt);
		}

	}

	static void onCore(int x, int y, int vec, int state) {

		switch (vec) {
		case 0: // 상
			for (int i = 0; i < x; i++) {
				map[i][y] = state;
			}
			break;
		case 1: // 하
			for (int i = x + 1; i < n; i++) {
				map[i][y] = state;
			}
			break;
		case 2: // 좌
			for (int i = 0; i < y; i++) {
				map[x][i] = state;
			}
			break;
		case 3: // 우
			for (int i = y + 1; i < n; i++) {
				map[x][i] = state;
			}
			break;
		}
	}


	static boolean check(int x, int y, int vec) {
		
		switch (vec) {
		case 0: // 상
			for (int i = 0; i < x; i++) {
				if (map[i][y] != 0) {
					return false;
				}
			}
			break;
		case 1: // 하
			for (int i = x + 1; i < n; i++) {
				if (map[i][y] != 0) {
					return false;
				}
			}
			break;
		case 2: // 좌
			for (int i = 0; i < y; i++) {
				if (map[x][i] != 0) {
					return false;
				}
			}
			break;
		case 3: // 우
			for (int i = y + 1; i < n; i++) {
				if (map[x][i] != 0) {
					return false;
				}
			}
			break;
		}
		return true;
	}
}
