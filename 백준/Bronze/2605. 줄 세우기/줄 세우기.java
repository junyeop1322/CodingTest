import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		Deque<Integer> dq = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			Stack<Integer> stk = new Stack<>();
			for (int j = 0; j < num; j++) {
				stk.add(dq.pollFirst());
			}
			
			dq.addFirst(i);
			
			while(!stk.isEmpty()) {
				dq.addFirst(stk.pop());
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(dq.pollLast() + " ");
		}
	}

}
