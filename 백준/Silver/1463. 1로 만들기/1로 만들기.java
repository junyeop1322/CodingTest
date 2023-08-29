import java.io.*;
import java.util.Arrays;

public class Main {

	static int min = 0;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		dp = new int[n + 1];
		Arrays.fill(dp, -1);

		dp[0] = 0;
		dp[1] = 0;

		System.out.println(recur(n));

	}

	static int recur(int n) {
		
		if (dp[n] == -1) {

			if (n % 6 == 0) {
				dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
			} else if (n % 3 == 0) {
				dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
			} else if (n % 2 == 0) {
				dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
			} else {
				dp[n] = recur(n - 1) + 1;
			}
		}
		return dp[n];
	}

}
