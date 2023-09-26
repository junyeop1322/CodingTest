import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map = new int[9][9];
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		dfs(0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	static void dfs(int d) {
		if (d == 81) {
			flag = true;
			return;
		}
		
		int x = d/9;
		int y = d%9;
		
		if (map[x][y] != 0) {
			dfs(d+1);
		} else {
			for (int i = 1; i < 10; i++) {
				if (!check(x, y, i)) {
					continue;
				}
				
				map[x][y] = i;
				dfs(d+1);
				
				if (flag) {
					return;
				}
				map[x][y] = 0;
			}
		}
	}
	
	static boolean check(int x, int y, int n) {
		
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == n || map[x][i] == n) {
				return false;
			}
		}
		
		int sx = (x/3) * 3;
		int sy = y - (y%3);
		
		for (int r = sx; r < sx+3; r++) {
			for (int c = sy; c < sy+3; c++) {
				if (map[r][c] == n) {
					return false;
				}
			}
		}
		
		return true;
	}

}
