import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map = new int[10][10];
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		
		dfs(0, 0, 0);
		
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		 System.out.println(ans);
		
	}

	static void dfs(int x, int y, int cnt) {
		if (x >= 9 && y > 9) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if (cnt >= ans) return;
		
		if (y > 9) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		if (map[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (paper[i] > 0 && checkPaper(x ,y, i)) {
					paper[i]--;
					addPaper(x, y, i, 0);
					dfs(x, y+1, cnt+1);
					paper[i]++;
					addPaper(x, y, i, 1);
				}
			}
		} else {
			dfs(x, y+1, cnt);
		}
	}
	
	static void addPaper(int x, int y, int size, int state) {
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				map[i][j] = state;
			}
		}
	}
	
	static boolean checkPaper(int x, int y, int size) {
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if (i < 0 || j < 0 || i >= 10 || j >= 10 || map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
}
