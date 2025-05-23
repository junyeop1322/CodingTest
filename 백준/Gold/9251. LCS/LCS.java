import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		char[] arr = str1.toCharArray();
		char[] brr = str2.toCharArray();
		
		int len1 = str1.length();
		int len2 = str2.length();

		int[][] dp = new int[len1 + 1][len2 + 1];
		
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (arr[i-1] == brr[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[len1][len2]);
	}

}
