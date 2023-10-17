import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<Integer> dq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String order = br.readLine();

			int num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			dq = new ArrayDeque<Integer>();

			for (int i = 0; i < num; i++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}

			AC(order);

		}

		System.out.println(sb);
	}

	static void AC(String order) {
		boolean check = true;

		for (char fun : order.toCharArray()) {
			if (fun == 'R') {
				check = !check;
				continue;
			}

			if (check) {
				if (dq.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			} else {
				if (dq.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}
		printString(check);

	}

	static void printString(boolean check) {
		sb.append('[');

		if (dq.size() > 0) {
			if (check) {
				sb.append(dq.pollFirst());

				while (!dq.isEmpty()) {
					sb.append(',').append(dq.pollFirst());
				}
			} else {
				sb.append(dq.pollLast());

				while (!dq.isEmpty()) {
					sb.append(',').append(dq.pollLast());
				}
			}
		}

		sb.append(']').append("\n");

	}

}
