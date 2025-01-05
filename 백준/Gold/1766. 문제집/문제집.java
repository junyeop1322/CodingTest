import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static StringBuilder sb;
	
	static boolean[] chk;
	static int[] brr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			arr[b]++;
		}
		
		Queue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= n; i++) {
			if (arr[i] == 0) {
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			
			sb.append(cur + " ");
			
			for (int next : graph.get(cur)) {
				arr[next]--;
				
				if (arr[next] == 0) {
					pq.offer(next);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
