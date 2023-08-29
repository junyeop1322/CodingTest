import java.io.*;
import java.util.Arrays;

public class Main {

	static long[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			dp = new long[n+1];
			Arrays.fill(dp, -1);
			dp[0] = 0;
			dp[1] = 1;
			
			if (n >= 2) {
				dp[2] = 1;
			}
			
			
			sb.append(find(n)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static long find(int x) {
		
		if (dp[x] == -1) {
			return dp[x] = find(x-3) + find(x-2);
		}
		
		return dp[x];
	}

}
