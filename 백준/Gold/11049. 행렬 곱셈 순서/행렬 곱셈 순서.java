import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n][n];
		
		for (int k = 1; k < n; k++ ) {
			for (int i = 0; i+k < n; i++) {
				dp[i][i+k] = Integer.MAX_VALUE;
				for (int j = i; j < i+k; j++) {
					dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j]+dp[j+1][i+k]+arr[i][0]*arr[j][1]*arr[i+k][1]);
				}
			}
		}
		
		System.out.println(dp[0][n-1]);
	}

}
