import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();

		char[] ch = str.toCharArray();
		int n = ch.length;
		
		int[][] dp = new int[n+1][n+1];
		
		String tmp = "";
		
		int res = 0;
		
		for (int i = 0; i < n-1; i++) {
			tmp = str.substring(i, i+2);
			
			if (tmp.equals("at") || tmp.equals("gc")) {
				dp[i][i+1] = 2;
				
				res = 2;
			}
		}
		
		for (int k = 2; k < n; k++) {
			for (int i = 0; i < n-k; i++) {
				int len = i + k;
				
				int len2 = 0;
				
				if (ch[i] == 'a' && ch[i+k] == 't') {
					len2 = 2;
				}
				
				if (ch[i] == 'g' && ch[i+k] == 'c') {
					len2 = 2;
				}
				
				dp[i][len] = Math.max(dp[i][len], dp[i+1][len-1] + len2);
				
				for (int j =i; j < len; j++) {
					dp[i][len] = Math.max(dp[i][len], dp[i][j] + dp[j+1][len]);
				}
				
				res = Math.max(res, dp[i][len]);
			}
		}
		
		System.out.println(res);
	}
}
