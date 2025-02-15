import java.io.*;
import java.util.*;

public class Main {
	
	static int ans;
	static int n, m;
	static String str1, str2;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = br.readLine();
		str2 = br.readLine();
		n = str1.length();
		m = str2.length();
		
		ans = 0;
		
		int[][] map = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					map[i][j] = map[i-1][j-1] + 1;
					ans = Math.max(ans, map[i][j]);
				}
			}
		}

		System.out.println(ans);
	}
	
}
