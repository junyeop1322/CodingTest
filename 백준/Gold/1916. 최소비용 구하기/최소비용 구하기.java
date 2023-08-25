import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int no;
		int w;
		
		public Node(int no, int w) {
			super();
			this.no = no;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] graph = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[n+1];
		boolean[] visit = new boolean[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int cur = pq.poll().no;
			
			if (visit[cur]) continue;
			visit[cur] = true;
			
			for (Node next : graph[cur]) {
				if (dist[next.no] > dist[cur] + next.w) {
					dist[next.no] = dist[cur] + next.w;
					
					pq.add(new Node(next.no, dist[next.no]));
				}
			}
		}
		
		System.out.println(dist[end]);
	}

}
