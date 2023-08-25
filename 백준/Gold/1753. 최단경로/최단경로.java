import java.util.*;
import java.io.*;

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
		
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		
		ArrayList<Node>[] graph = new ArrayList[v+1];
		for (int i = 0; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int start = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to, weight));
		}

		
		boolean[] check = new boolean[v+1];
		int[] dist = new int[v+1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		
		while (!pq.isEmpty()) {
			int curNo = pq.poll().no;
			
			if (check[curNo]) continue;
			check[curNo] = true;
			
			for (Node next : graph[curNo]) {
				if (dist[next.no] > dist[curNo] + next.w) {
					dist[next.no] = dist[curNo] + next.w;
					
					pq.offer(new Node(next.no, dist[next.no]));
				}
			}
			
		}
		
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

}
