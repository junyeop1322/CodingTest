import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] brr = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] dp = new boolean[n+1][40001];
		
		dp[0][0] = true;
		dp[0][arr[0]] = true;
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 40001; j++) {
				dp[i][j] = dp[i-1][j] || dp[i][j];
				
				if (dp[i-1][j]) {
					if (j + arr[i] <= 40000) {
						dp[i][j+arr[i]] = true;
					}
					
					dp[i][Math.abs(j - arr[i])] = true;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			if (dp[n-1][brr[i]]) {
				sb.append("Y ");
			} else {
				sb.append("N ");
			}
		}

		System.out.println(sb.toString());
	} 

}
