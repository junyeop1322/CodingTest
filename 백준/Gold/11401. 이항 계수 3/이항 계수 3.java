import java.io.*;
import java.util.*;

public class Main {

	static long num = 1000000007;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		
		long number = factorial(n);
		long denom = factorial(k) * factorial(n-k) % num;
		
		System.out.println(number * pow(denom, num-2) % num);
		
	}
	
	static long factorial(long n) {
		long fac = 1L;
		
		while(n > 1) {
			fac = (fac * n) % num;
			n--;
		}
		
		return fac;
	}
	
	static long pow(long base, long expo) {
		
		if (expo == 1) {
			return base % num;
		}
		
		long tmp = pow(base, expo/2);
		
		if (expo % 2 == 1) {
			return (tmp * tmp % num) * base % num;
		}
		
		return tmp * tmp % num;
	}
	
}
