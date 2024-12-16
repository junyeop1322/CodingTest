import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][][] dp = new int[n+1][10][1 << 10];
		
		for (int i = 1; i < 10; i++) {
			dp[1][i][1 << i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < (1 << 10); k++) {
					if (j == 0) {
						dp[i][0][1 << 0 | k] = (dp[i][0][1 << 0 | k] + dp[i-1][1][k]) % INF;
					} else if (j == 9) {
						dp[i][9][1 << 9 | k] = (dp[i][9][1 << 9 | k] + dp[i-1][8][k]) % INF;
					} else {
						dp[i][j][1 << j | k] = (dp[i][j][1 << j | k] + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % INF;
					}
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < 10; i++ ) {
			ans = (ans + dp[n][i][(1 << 10) - 1]) % INF;
		}
		
		System.out.println(ans);

	}

}
