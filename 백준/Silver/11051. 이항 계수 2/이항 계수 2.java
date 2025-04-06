import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] dp;
	static int MOD = 10007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dp = new int[n+1][k+1];
		
		int ans = func(n, k);
		
		System.out.println(ans);
	}
	
	static int func(int n, int k) {
		if (dp[n][k] > 0) {
			return dp[n][k];
		}
		
		if (k == 0 || n == k) {
			return dp[n][k] = 1;
		}
		
		
		return dp[n][k] = (func(n-1, k-1) + func(n-1, k)) % MOD;
	}

}
