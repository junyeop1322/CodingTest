import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);

		long a = 0;
		long b = 0;
		long c = 0;

		long min = 3000000000L;

		for (int i = 0; i < n - 2; i++) {
			int start = i + 1;
			int end = n - 1;

			while (start < end) {
				long sum = arr[start] + arr[i] + arr[end];
				long sumA = Math.abs(sum);

				if (sumA < min) {
					a = arr[i];
					b = arr[start];
					c = arr[end];
					min = sumA;
				}
				
				if (sum > 0) {
					end--;
				} else {
					start++;
				}
			}
		}
		
		System.out.println(a + " " + b + " " + c);

	}

}
