import java.io.*;
import java.util.*;

public class Main {
	
	static long[] dp = new long[55];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long ans = 0;
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		calDp();
		
		ans = countRange(b) - countRange(a-1);
		System.out.println(ans);
	}
	
	static long countRange(long num) {
		long count = num & 1;
		
		int size = (int)(Math.log(num)/Math.log(2));
		
		for (int i = size; i > 0; i--) {
			if ((num & (1L<<i)) != 0L) {
				count += dp[i-1] + (num - (1L<<i) + 1);
				num -= (1L<<i);
			}
		}
		
		return count;
	}
	
	static void calDp() {
		dp[0] = 1;
		
		for (int i = 1; i < 55; i++) {
			dp[i] = (dp[i-1]<<1) + (1L<<i);
		}
	}

}
