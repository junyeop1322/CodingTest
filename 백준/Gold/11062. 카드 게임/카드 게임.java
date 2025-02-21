import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n+1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[n+2][n+1];
			
			boolean chk = (n % 2 == 1);
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j + i - 1 <= n; j++) {
					int left = j;
					int right = j + i - 1;
					
					if (chk) {
						dp[left][right] = Math.max(dp[left+1][right] + arr[left], dp[left][right-1] + arr[right]);
					} else {
						dp[left][right] = Math.min(dp[left+1][right], dp[left][right-1]);
					}
				}
				
				chk = !chk;
			}
			
			sb.append(dp[1][n] + "\n");
		}

		System.out.println(sb.toString());
	}

}
