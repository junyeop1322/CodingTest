import java.io.*;
import java.util.Arrays;

public class Main {

	static long[] dp;
	static long[] dp2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			dp2 = new long[41];
			dp = new long[41];

			dp[0] = 1;
			dp2[0] = 0;
			dp[1] = 0;
			dp2[1] = 1;

			for (int i = 2; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
				dp2[i] = dp2[i - 1] + dp2[i - 2];
			}

			sb.append(dp[n] + " " + dp2[n] + "\n");
		}
		System.out.println(sb);
	}

}
