import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int ans = a % 10;

			for (int i = 1; i < b; i++) {
				ans = (ans * a) % 10;
			}

			if (ans == 0) {
				sb.append(10).append("\n");
			} else {
				sb.append(ans + "\n");
			}
		}
		System.out.println(sb);
	}

}
