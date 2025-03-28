import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][3];
		long[][] dp1 = new long[n+1][3];
		long[][] dp2 = new long[n+1][3];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		dp1[1][0] = arr[1][0];
		dp1[1][1] = arr[1][1];
		dp1[1][2] = arr[1][2];

		dp2[1][0] = arr[1][0];
		dp2[1][1] = arr[1][1];
		dp2[1][2] = arr[1][2];
		
		for (int i = 2; i <= n; i++) {
			dp1[i][0] = Math.max(dp1[i-1][0] + arr[i][0], dp1[i-1][1] + arr[i][0]);
			dp1[i][1] = Math.max(dp1[i-1][1] + arr[i][1], Math.max(dp1[i-1][0] + arr[i][1], dp1[i-1][2] + arr[i][1]));
			dp1[i][2] = Math.max(dp1[i-1][2] + arr[i][2], dp1[i-1][1] + arr[i][2]);
			
			dp2[i][0] = Math.min(dp2[i-1][0] + arr[i][0], dp2[i-1][1] + arr[i][0]);
			dp2[i][1] = Math.min(dp2[i-1][1] + arr[i][1], Math.min(dp2[i-1][0] + arr[i][1], dp2[i-1][2] + arr[i][1]));
			dp2[i][2] = Math.min(dp2[i-1][2] + arr[i][2], dp2[i-1][1] + arr[i][2]);
		}
		
		long max = Math.max(dp1[n][0], Math.max(dp1[n][1], dp1[n][2]));
		long min = Math.min(dp2[n][0], Math.min(dp2[n][1], dp2[n][2]));
		
		System.out.println(max + " " + min);
	}

}
