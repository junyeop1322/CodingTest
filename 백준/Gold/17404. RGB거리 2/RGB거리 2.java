import java.io.*;
import java.util.*;


public class Main {
	
	static int INF = 1_000*1_000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][3];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		int[][] dp = new int[n+1][3];
		int ans = INF;
		
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 3; i++) {
				if (k == i) {
					dp[1][i] = arr[1][i];
				} else {
					dp[1][i] = INF;
				}
			}
			
			for (int i = 2; i <= n; i++) {
				dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = arr[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
			}
			
			for (int i = 0; i < 3; i++) {
				if (i != k) {
					ans = Math.min(ans, dp[n][i]);
				}
			}
		}
		
		System.out.println(ans);
	}

}
