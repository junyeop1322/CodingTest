import java.io.*;
import java.util.*;

public class Main {

	static int n;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());

		int[] train = new int[n+1];
		int[] sum = new int[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			train[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + train[i];
		}
		
		int[][] dp = new int[4][n+1];
		
		int max = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 3; i++) {
			for (int j = i*max; j <= n; j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-max] + sum[j] - sum[j-max]);
			}
		}
		
		System.out.println(dp[3][n]);
	}

}
