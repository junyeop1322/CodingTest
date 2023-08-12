import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int ans = 0;
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			boolean isPrime = true;

			if (num == 1) {
				continue;
			}
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				ans++;
			}
		}
		System.out.println(ans);

	}
}
