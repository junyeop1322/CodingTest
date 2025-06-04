import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n+1];
		int ans = 0;
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dp[i] = a;
			
			for (int j = 0; j < b; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				dp[i] = Math.max(dp[i], dp[num] + a);
			}
			
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}

}
