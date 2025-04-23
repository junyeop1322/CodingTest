import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a < b) {
				pq.add(new int[] {a, b});
			} else {
				pq.add(new int[] {b, a});
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int d = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int start = cur[1] - d;
			q.add(cur[0]);
			
			while(!q.isEmpty() && q.peek() < start) {
				q.poll();
			}
			
			ans = Math.max(ans, q.size());
		}
		
		System.out.println(ans);
	}

}
