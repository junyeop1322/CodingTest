import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());

			map = new int[2][n+1];
			dp = new int[2][n+1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			
			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i];
				
			}
			int ans = Math.max(dp[0][n], dp[1][n]);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
