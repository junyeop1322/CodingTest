import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num != 0) {
				pq.offer(num);
			} else {
				if (pq.isEmpty()) {
					sb.append("0 \n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}

}
