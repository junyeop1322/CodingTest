import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] dp = new long[n+1];
		
		dp[0] = 1;
		
		for (int i = 2; i <= n; i+=2) {
			dp[i] = dp[i-2]*3;
			for (int j = i-4; j >= 0; j-=2) {
				dp[i] += dp[j]*2;
			}
		}
		
		System.out.println(dp[n]);
	}
}
