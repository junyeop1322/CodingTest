import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Deque<int[]> dq = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!dq.isEmpty() && dq.peekLast()[0] > num) {
				dq.pollLast();
			}
			
			dq.offer(new int[] {num, i});
			
			if (dq.peek()[1] < i - (l-1)) {
				dq.poll();
			}
			
			sb.append(dq.peek()[0]).append(" ");
		}

		System.out.println(sb.toString());
	}

}
