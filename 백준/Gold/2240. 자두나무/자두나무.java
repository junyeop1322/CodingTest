import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[][] dp = new int[t+1][w+1];
		int[] arr = new int[t+1];
		
		for (int i = 1; i <= t; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		int pos = 1;
		
		for (int i = 1; i <= t; i++) {
			int tree = arr[i];
			
			for (int j = 0; j <= w; j++) {
				if (j == 0) {
					pos = 1;
					
					if (tree == pos) {
						dp[i][j] = dp[i-1][j] + 1;
					} else {
						dp[i][j] = dp[i-1][j];
					}
					
					continue;
				}
				
				if (j % 2 == 0) {
					pos = 1;
					
					if (pos == tree) {
						dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
					} else {
						dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
					}
				} else {
					pos = 2;
					
					if (pos == tree) {
						dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
					} else {
						dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
					}
				}
				
				ans = Math.max(ans, dp[i][j]);
			}
		}
		
		System.out.println(ans);
	}

}
