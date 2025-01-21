import java.io.*;

public class Main {
	
	static int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		if (n == 0) {
			System.out.println(0);
		} else {
			long[][] arr = {{1, 1}, {1, 0}};
			long[][] result = pow(arr, n);
			
			System.out.println(result[1][0] % MOD);
		}

	}
	
	static long[][] pow(long[][] arr, long n) {
		if (n == 1) {
			return arr;
		}
		
		long[][] temp = pow(arr, n/2);
		
		if (n % 2 == 0) {
			return mul(temp, temp);
		} else {
			return mul(mul(temp, temp), arr);
		}
	}
	
	static long[][] mul(long[][] arr, long[][] brr) {
		long[][] temp = new long[2][2];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					temp[i][j] += arr[i][k] * brr[k][j];
					temp[i][j] %= MOD;
				}
			}
		}
		
		return temp;
	}

}
