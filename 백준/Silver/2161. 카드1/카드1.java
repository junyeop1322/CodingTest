import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			dq.addLast(i);
		}
		
		while(!dq.isEmpty()) {
			sb.append(dq.pollFirst()).append(" ");
			
			if (dq.isEmpty()) {
				break;
			}
			
			dq.addLast(dq.pollFirst());
		}

		System.out.println(sb.toString());
	}

}
