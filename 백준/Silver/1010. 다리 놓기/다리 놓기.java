import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			dp = new int[31][31];
			
			for (int i = 0; i < 31; i++) {
				Arrays.fill(dp[i], -1);
			}
			for (int i = 0; i < 31; i++) {
				for (int j = 0; j < 31; j++) {
					if (i == j || j == 0) {
						dp[i][j] = 1;
					}
				}
			}
			
			sb.append(comb(m, n)).append("\n");
		}
		
		System.out.println(sb);
	}

	static int comb(int a, int b) {
		if (a == b || a == 0) {
			return dp[a][b];
		}
		
		if (dp[a][b] == -1) {
			return dp[a][b] = comb(a-1, b-1) + comb(a-1, b);
		}
		
		return dp[a][b];
	}
	
}
