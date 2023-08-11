import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> dq = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int x = 0;
			
			switch(s) {
			case "push_front":
				x = Integer.parseInt(st.nextToken());
				dq.offerFirst(x);
				break;
			case "push_back":
				x = Integer.parseInt(st.nextToken());
				dq.offerLast(x);
				break;
			case "pop_front":
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.pollFirst()).append("\n");
				}
				break;
			case "pop_back":
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.pollLast()).append("\n");
				}
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				if (dq.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "front":
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.peekFirst()).append("\n");
				}
				break;
			case "back":
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}

}
