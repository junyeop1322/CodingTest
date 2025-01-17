import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int MOD = 10007;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[53][53];
		
		for (int i = 0; i <= 52; i++) {
			arr[i][0] = 1;
		}
		
		for (int i = 1; i <= 52; i++) {
			for (int j = 1; j <= 52; j++) {
				arr[i][j] = (arr[i-1][j] + arr[i-1][j-1]) % MOD;
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= 13 && n-4*i >= 0; i++) {
			int num = (arr[52-4*i][n-4*i] * arr[13][i]) % MOD;
			
			if (i % 2 == 1) {
				ans = (ans + num) % MOD;
			} else {
				ans = (ans - num + MOD) % MOD;
			}
		}
		
		System.out.println(ans);
	}

}
