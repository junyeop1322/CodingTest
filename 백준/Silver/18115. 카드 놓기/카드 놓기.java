import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new LinkedList<>();
		
		st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num == 1) {
				dq.addFirst(i);
			} else if (num == 2) {
				int tmp = dq.pollFirst();
				dq.addFirst(i);
				dq.addFirst(tmp);
			} else {
				dq.addLast(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!dq.isEmpty()) {
			sb.append(dq.pollFirst()).append(" ");
		}

		System.out.println(sb.toString());
	}

}
