import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][3];
		dp = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];

		System.out.println(Math.min(paint(n - 1, 0), Math.min(paint(n - 1, 1), paint(n - 1, 2))));

	}

	static int paint(int x, int color) {

		if (x == 0) {
			return dp[x][color];
		}
		
		if (dp[x][color] == 0) {
			if (color == 0) {
				return dp[x][color] = Math.min(paint(x - 1, 1), paint(x - 1, 2)) + map[x][color];
			}
			if (color == 1) {
				return dp[x][color] = Math.min(paint(x - 1, 0), paint(x - 1, 2)) + map[x][color];
			}
			if (color == 2) {
				return dp[x][color] = Math.min(paint(x - 1, 0), paint(x - 1, 1)) + map[x][color];
			}
		}
		return dp[x][color];
	}

}
