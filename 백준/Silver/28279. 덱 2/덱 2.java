import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<>();
		
//		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
//		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
//			int order = sc.nextInt();
			int x = 0;
			
			switch(order) {
			case 1:
				x = Integer.parseInt(st.nextToken());
//				x = sc.nextInt();
				dq.offerFirst(x);
				break;
			case 2:
				x = Integer.parseInt(st.nextToken());
//				x = sc.nextInt();
				dq.offerLast(x);
				break;
			case 3:
				if (!dq.isEmpty()) {
					sb.append(dq.pollFirst()).append("\n");
				} else {
					sb.append("-1\n");
				}
				break;
			case 4:
				if (!dq.isEmpty()) {
					sb.append(dq.pollLast()).append("\n");
				} else {
					sb.append("-1\n");
				}
				break;
			case 5:
				sb.append(dq.size()).append("\n");
				break;
			case 6:
				if (!dq.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append("1\n");
				}
				break;
			case 7:
				if (!dq.isEmpty()) {
					sb.append(dq.peekFirst()).append("\n");
				} else {
					sb.append("-1\n");
				}
				break;
			case 8:
				if (!dq.isEmpty()) {
					sb.append(dq.peekLast()).append("\n");
				} else {
					sb.append("-1\n");
				}
				break;
			}
		}
		
		System.out.println(sb);
		
	}

}
