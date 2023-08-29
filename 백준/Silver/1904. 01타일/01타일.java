import java.io.*;
import java.util.Arrays;

public class Main {

	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		if (n >= 2) {
			dp[2] = 2;
		}
		System.out.println(find(n));
	}
	
	static int find(int x) {
		
		if (dp[x] == -1) {
			return dp[x] = (find(x-1) + find(x-2)) % 15746;
		}
		
		return dp[x];
	}

}
