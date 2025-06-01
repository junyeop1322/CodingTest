import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if (n == 0) {
			System.out.println(0);
		} else if (n == 1) {
			System.out.println(1);
		} else {
			BigInteger[] dp = new BigInteger[n+1];
			
			dp[0] = BigInteger.ZERO;
			dp[1] = BigInteger.ONE;
			
			for (int i = 2; i <= n; i++) {
				dp[i] = dp[i-1].add(dp[i-2]);
			}
			
			System.out.println(dp[n]);
		}

	}

}
