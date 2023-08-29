import java.io.*;
import java.util.*;

public class Main {

	static long cnt1 = 0;
	static long cnt2 = -1;
	static long[] dp;
	
	static long fibo1(int n) {
		if (n <= 2) {
			cnt1++;
			return 1;
		}
		return fibo1(n-1) + fibo1(n-2);
	}
	
	static long fibo2(int n) {
		if (dp[n] == -1) {
			cnt2++;
			dp[n] = fibo2(n-1) + fibo2(n-2);
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		dp = new long[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		
		
		fibo1(n);
		fibo2(n);
		
		sb.append(cnt1).append(" ").append(cnt2).append("\n");
		
		System.out.println(sb);
		
	}

}
