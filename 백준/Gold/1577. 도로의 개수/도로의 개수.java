import java.io.*;
import java.util.*;


public class Main {
	
	static int n, m;
	static long[][] dp;
	static boolean[][][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new long[n+1][m+1];
		map = new boolean[n+1][m+1][2];
		
		
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if (a < c || b < d) {
				if (a < c) {
					map[a][b][1] = true;
				} else {
					map[a][b][0] = true;
				}
			} else {
				if (c < a) {
					map[c][d][1] = true;
				} else {
					map[c][d][0] = true;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (map[i-1][0][1]) {
				break;
			}
			
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= m; i++) {
			if (map[0][i-1][0]) {
				break;
			}
			
			dp[0][i] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (!map[i][j-1][0]) {
					dp[i][j] += dp[i][j-1];
				}
				
				if (!map[i-1][j][1]) {
					dp[i][j] += dp[i-1][j];
				}	
			}
		}
		
 		System.out.println(dp[n][m]);
	}
	

}
