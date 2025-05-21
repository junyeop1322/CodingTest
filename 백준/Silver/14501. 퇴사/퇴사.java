import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int[] brr = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = Integer.parseInt(st.nextToken());
			brr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		
		for (int i = 0; i < n; i++) {
			if (i + arr[i] <= n) {
				dp[i+arr[i]] = Math.max(dp[i+arr[i]], dp[i] + brr[i]);
			}
			
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}

		System.out.println(dp[n]);
	}

}
