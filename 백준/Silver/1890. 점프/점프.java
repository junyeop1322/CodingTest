import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp = new long[n][n];
		dp[0][0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int num = map[i][j];
				if (num == 0) {
					break;
				}
				
				if (i + num < n) {
					dp[i + num][j] += dp[i][j];
				}
				
				if (j + num < n) {
					dp[i][j + num] += dp[i][j];
				}
			}
		}
		
		System.out.println(dp[n-1][n-1]);
	}

}
