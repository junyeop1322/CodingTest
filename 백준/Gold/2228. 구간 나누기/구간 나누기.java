import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[] arr, sum;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n+1];
		sum = new int[n+1];
		dp = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum[i] = sum[i-1] + arr[i];
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Integer.MIN_VALUE / 2;
			}
		}
		
		dp[1][1] = arr[1];
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i-1][j];
				
				int min = 0;
				if (j == 1) {
					min = -1;
				}
				
				for (int k = i-2; k >= min; k--) {
					if (k < 0) {
						dp[i][j] = Math.max(dp[i][j], sum[i]);
					} else {
						dp[i][j] = Math.max(dp[i][j], dp[k][j-1] + sum[i] - sum[k+1]);
					}
				}
			}
		}
		
		System.out.println(dp[n][m]);
	}

}
