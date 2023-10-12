import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {

		int from;
		int to;
		int cost;
		
		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
	}

	static int V, E;
	static int[] parents;
	static ArrayList<Node> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V+1];
		list = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.add(new Node(from, to, cost));	
		}
		
		Collections.sort(list);
		make();
		
		int ans = 0;
		int num = 0;
		
		for (Node n : list) {
			if (find(n.from) != find(n.to)) {
				union(n.from, n.to);
				
				ans += n.cost;
				num = n.cost;
			}
		}
		
		System.out.println(ans-num);
		
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parents[x] = y;
		}
	}
	
	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		
		return parents[x] = find(parents[x]);
	}
	
	static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}

}
