import java.io.*;
import java.util.*;

public class Main {

	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		LCS(str1, str2);
		
		int i = str1.length();
		int j = str2.length();
		
		Stack<Character> stack = new Stack<>();
		while (i > 0 && j > 0) {
			
			if (i == 0 || j == 0) {
				break;
			}
			
			if (dp[i][j] == dp[i-1][j]) {
				i--;
			} else if (dp[i][j] == dp[i][j-1]) {
				j--;
			} else {
				stack.push(str1.charAt(i-1));
				i--;
				j--;
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
	
	static void LCS(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();
		
		dp = new int[n1+1][n2+1];
		int max = -1;
		
		for (int i = 1; i < n1+1; i++) {
			for (int j = 1; j < n2+1; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		sb.append(dp[n1][n2] + "\n");
	}

}
