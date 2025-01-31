import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr = new int[501];
	static int[][] dp = new int[501][501];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(st.nextToken());
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
			}
			
			func(n);
			
			sb.append(dp[1][n] + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void func(int k) {
		for (int i = 2; i <= k; i++) {
			for (int j = i-1; j >= 1; j--) {
				dp[j][i] = Integer.MAX_VALUE;
				for (int s = j; s < i; s++) {
					dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s+1][i]);
				}
				dp[j][i] += arr[i] - arr[j-1];
			}
		}
	}

}
