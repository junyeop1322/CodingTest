import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] mileage = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			int[] tmp_mileage = new int[p];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < p; j++) {
				tmp_mileage[j] = Integer.parseInt(st.nextToken());
			}

			if (p >= l) {
				Arrays.sort(tmp_mileage);
				mileage[i] = tmp_mileage[p - l];
			} else {
				mileage[i] = 1;
			}
		}
		System.out.println(countMaxSubject(mileage, m));
	}

	public static int countMaxSubject(int[] mileage, int m) {
		Arrays.sort(mileage);
		int sum = 0, count = 0;
		for (int i = 0; i < mileage.length; i++) {
			sum += mileage[i];
			if (sum > m) {
				break;
			}
			count++;
		}
		return count;
	}
}