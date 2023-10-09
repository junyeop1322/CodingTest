import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		for(int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	static void dfs(int d) {
		if (d == 81) {
			flag = true;
			return;
		}
		
		int x = d / 9;
		int y = d % 9;
		
		if (map[x][y] != 0) {
			dfs(d+1);
		} else {
			for (int i = 1; i <= 9; i++) {
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
	
	static boolean check(int x, int y, int num) {
		
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == num || map[x][i] == num) {
				return false;
			}
		}
		
		int dx = (x/3) * 3;
		int dy = y - (y%3);
		
		for (int i = dx; i < dx+3; i++) {
			for (int j = dy; j < dy+3; j++) {
				if (map[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}

}
