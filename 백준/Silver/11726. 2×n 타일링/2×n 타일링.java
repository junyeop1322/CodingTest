import java.io.*;
import java.util.Arrays;

public class Main {
	
	static int n;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new long[n+1];
		Arrays.fill(dp, -1);
		
		long ans = fibo(n);
		
		System.out.println(ans);
		
	}

	static long fibo(int n) {
		if (n == 1) {
			return dp[n] = 1;
		}
		if (n == 2) {
			return dp[n] = 2;
		}
		
		if (dp[n] == -1) {
			return dp[n] = (fibo(n-1) + fibo(n-2)) % 10007;
		}
		
		return dp[n];
	}
	
}
