import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] dp;
	static boolean[][] palin;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		n = str.length();
		
		palin = new boolean[n+1][n+1];
		dp = new int[n+1];
		str = "." + str;
		
		checkPalin(str);
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (palin[j][i]) {
					dp[i] = Math.min(dp[i], dp[j-1] + 1);
				}
			}
		}
		
		System.out.println(dp[n]);
	}
	
	static void checkPalin(String str) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				boolean chk = true;
				int a = j;
				int b = i;
				
				while(a <= b) {
					if (str.charAt(a++) != str.charAt(b--)) {
						chk = false;
						break;
					}
				}
				
				if (chk) {
					palin[j][i] = true;
				}
			}
		}
	}

}
