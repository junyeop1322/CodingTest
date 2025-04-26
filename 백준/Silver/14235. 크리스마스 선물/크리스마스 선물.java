import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			return o2 - o1;
		});

		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			
			if (m == 0) {
				if (pq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				for (int j = 0; j < m; j++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
