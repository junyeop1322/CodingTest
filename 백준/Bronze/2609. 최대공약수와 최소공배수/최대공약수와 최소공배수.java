import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = 0;
		for (int i = 1; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				if (i > gcd) {
					gcd = i;
				}
			}
		}
		
		int lcm = a * b;
		for (int i = Math.max(a, b); i <= a*b; i++) {
			if (i % a == 0 && i % b == 0) {
				if (i < lcm) {
					lcm = i;
				}
			}
		}
		System.out.println(gcd + " " + lcm);
	}

}
