import java.io.*;
import java.util.Arrays;

public class Main {

	static int n;
	static long[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp = new long[n+1];
		Arrays.fill(dp, -1);
		dp[1] = 1;
		
		System.out.println(fibo(n));
		
	}

	static long fibo(int n) {
		if (n == 1) {
			return dp[n];
		}
		
		if (dp[n] == -1) {
			if (n % 2 == 0) {
				return dp[n] = (fibo(n-1)*2 + 1)%10007;
			}
			if (n % 2 == 1) {
				return dp[n] = (fibo(n-1)*2 -1)%10007;
			}
		}
		
		return dp[n];
	}
	
}
