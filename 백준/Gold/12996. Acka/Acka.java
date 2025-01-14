import java.io.*;
import java.util.*;

public class Main {

	static int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][][][] dp = new int[n+1][a+1][b+1][c+1];
		
		for (int[][][] arr1 : dp) {
			for (int[][] arr2 : arr1) {
				for (int[] arr3 : arr2) {
					Arrays.fill(arr3, -1);
				}
			}
		}
		
		System.out.println(memo(dp, n, a, b, c));
	}
	
	static int memo(int[][][][] dp, int n, int a, int b, int c) {
		int sum = 0;
		
		if (n < 0 || a < 0 || b < 0 || c < 0) {
			return 0;
		}
		
		if (n == 0) {
			if (a == 0 && b == 0 && c == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		
		if (dp[n][a][b][c] != -1) {
			return dp[n][a][b][c];
		}
		
		sum = (sum + memo(dp, n-1, a-1, b, c)) % MOD;
		sum = (sum + memo(dp, n-1, a, b-1, c)) % MOD;
		sum = (sum + memo(dp, n-1, a, b, c-1)) % MOD;
		sum = (sum + memo(dp, n-1, a-1, b-1, c)) % MOD;
		sum = (sum + memo(dp, n-1, a-1, b, c-1)) % MOD;
		sum = (sum + memo(dp, n-1, a, b-1, c-1)) % MOD;
		sum = (sum + memo(dp, n-1, a-1, b-1, c-1)) % MOD;
		
		dp[n][a][b][c] = sum;
		
		return sum;
	}

}
