import java.io.*;
import java.util.Arrays;

public class Main {

	static int[] dp;
	static int[] map;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n+1];
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		for (int i = 1; i <= n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = map[0];
		dp[1] = map[1];
		
		if (n >= 2) {
			dp[2] = map[1]+ map[2];
		}
		
		System.out.println(point(n));
		
	}

	static int point(int x) {
		
		if (dp[x] == -1) {
//			System.out.println(x + " ====== " + map[x]);
			return dp[x] = Math.max(point(x-2), point(x-3) + map[x-1]) + map[x];
		}
		
		return dp[x];
	}
}
