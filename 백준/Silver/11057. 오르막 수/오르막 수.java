import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[n+1][10];
		
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k];
				}
				
				dp[i][j] %= 10007; 
			}
		}
		
		long ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += dp[n][i];
		}
		
		System.out.println(ans % 10007);
	}

}
