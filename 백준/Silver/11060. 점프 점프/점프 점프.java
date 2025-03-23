import java.io.*;
import java.util.*;


public class Main {

	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		long[] dp = new long[1101];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		
		dp[1] = 0;
		for (int i = 1; i <= n; i++) {
			if (dp[i] >= Integer.MAX_VALUE) {
				continue;
			}
			
			for (int j = 1; j <= arr[i]; j++) {
				dp[i+j] = Math.min(dp[i+j], dp[i]+1);
			}
		}
		
		if (dp[n] >= Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[n]);
		}
		
	}

}
