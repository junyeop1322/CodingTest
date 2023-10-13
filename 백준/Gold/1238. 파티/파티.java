import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {

		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int n, m, t;
	static List<Node>[] nList;
	static List<Node>[] rList;
	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		nList = new ArrayList[n+1];
		rList = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			nList[i] = new ArrayList<>();
			rList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			nList[from].add(new Node(to, cost));
			rList[to].add(new Node(from, cost));
		}
		
		int[] go = dijkstra(nList, t);
		int[] back = dijkstra(rList, t);
		
		int ans = Integer.MIN_VALUE;
		
		for (int i = 1; i < n+1; i++) {
			int dis = go[i] + back[i];
			
			if (dis > ans) {
				ans = dis;
			}
		}
		
		System.out.println(ans);
	}
	
	static int[] dijkstra(List<Node>[] list, int start) {
		Queue<Node> q = new PriorityQueue<>();
		boolean[] check = new boolean[n+1];
		int[] dp = new int[n+1];
		Arrays.fill(dp, INF);
		
		q.add(new Node(start, 0));
		dp[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int to = cur.to;
			
			if (check[to]) continue;
			
			check[to] = true;
			
			for (Node n : list[to]) {
				if (dp[to] + n.cost < dp[n.to]) {
					dp[n.to] = dp[to] + n.cost;
					q.add(new Node(n.to, dp[n.to]));
				}
			}
		}
		
		return dp;
	}

}
