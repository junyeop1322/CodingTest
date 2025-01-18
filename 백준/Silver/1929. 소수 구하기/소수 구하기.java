import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = n; i <= m; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	
	static boolean isPrime(int num) {
		boolean chk = true;
		
		if (num == 1) {
			return false;
		} else if (num == 2) {
			return true;
		}
		
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				chk = false;
				break;
			}
		}
		
		return chk;
	}

}
