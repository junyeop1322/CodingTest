import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static char[] res;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		res = new char[n];
		arr = new char[m];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			String str = st.nextToken();
			arr[i] = str.charAt(0);
		}
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		comb(0, 0);

	}

	static void comb(int cnt, int start) {
		if (cnt == n) {
			boolean check = false;
			boolean check2 = false;

			for (int i = 0; i < n; i++) {
				if (res[i] == 'a' || res[i] == 'i' || res[i] == 'u' || res[i] == 'e' || res[i] == 'o') {
					check = true;
				}
			}

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (res[i] != 'a' && res[i] != 'i' && res[i] != 'u' && res[i] != 'e' && res[i] != 'o') {
						if (res[j] != 'a' && res[j] != 'i' && res[j] != 'u' && res[j] != 'e' && res[j] != 'o') {
							check2 = true;
						}
					}
				}
			}

			if (check && check2) {
				for (int i = 0; i < n; i++) {
					System.out.print(res[i]);
				}
				System.out.println();
			}
			return;
		}

		for (int i = start; i < m; i++) {
			res[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}

}
