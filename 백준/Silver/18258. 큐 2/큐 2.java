import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		Deque<Integer> arr = new LinkedList<>();
		
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int num = 0;
			
			switch(s) {
			case "push":
				num = Integer.parseInt(st.nextToken());
				arr.offer(num);
				break;
			case "pop":
				if (arr.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(arr.poll()).append("\n");
				}
				break;
			case "size":
				sb.append(arr.size()).append("\n");
				break;
			case "empty":
				if (arr.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "front":
				if (arr.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(arr.peek()).append("\n");
				}
				break;
			case "back":
				if (arr.isEmpty() ) {
					sb.append("-1\n");
				} else {
					sb.append(arr.peekLast()).append("\n");
				}
				break;
			}
		}
		
		System.out.println(sb);
	}

}
