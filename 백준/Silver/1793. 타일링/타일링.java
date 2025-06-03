import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger[] dp = new BigInteger[251];
		
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");

		for (int i = 3; i < 251; i++) {
			dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
		}
		
		String str = null;
		
		while((str = br.readLine()) != null) {
			int n = Integer.parseInt(str);
			
			System.out.println(dp[n]);
		}
	}

}
