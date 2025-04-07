import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int ans = Integer.MAX_VALUE;
		
		int[] arr = new int[n];
		int[] cost = new int[n];
		int[][] dp = new int[n][100001];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			int c = cost[i];
			int a = arr[i];
			
			for (int j = 0; j < 100001; j++) {
				if (i == 0) {
					if (j >= c) {
						dp[i][j] = a;
					}
				} else {
					if (j >= c) {
						dp[i][j] = Math.max(dp[i-1][j-c] + a, dp[i-1][j]);
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
				
				if (dp[i][j] >= m) {
					ans = Math.min(ans, j);
				}
			}
		}
		
		System.out.println(ans);
	}

}
