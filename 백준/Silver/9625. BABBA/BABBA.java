import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[2][46];
		dp[0][2] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for (int i = 3; i < 46; i++) {
			dp[0][i] = dp[0][i-1] + dp[0][i-2];
			dp[1][i] = dp[1][i-1] + dp[1][i-2];
		}

		System.out.println(dp[0][n] + " " + dp[1][n]);
	}

}
