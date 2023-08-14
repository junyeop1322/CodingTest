import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		int N = str.length();
		int[] arr = new int[N];
		int ans = -1;
		boolean check = false;

		for (int i = 0; i < N; i++) {
			arr[i] = (int) (str.charAt(i) - '0');
		}
		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			if (arr[i] == 0) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += arr[j];
				}
				if ((sum % 3) == 0) {
					check = true;
				}
			}
		}

		if (check) {
			for (int i = N - 1; i >= 0; i--) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
		} else {
			System.out.println(ans);
		}
	}

}
