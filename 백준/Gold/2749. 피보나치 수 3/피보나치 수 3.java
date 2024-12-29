import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Long n = Long.parseLong(st.nextToken());
		
		long[] dp = new long[1500000];
		
		long num = n % 1500000;
		
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
		}
		
		System.out.println(dp[(int)num]);
	}

}
