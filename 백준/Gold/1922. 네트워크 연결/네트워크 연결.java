import java.io.*;
import java.util.*;

public class Main {

	public static class Node implements Comparable<Node> {

		int from;
		int to;
		int cost;
		
		public Node(int from, int to, int cost) {
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
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
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
		
		int sum = 0;
		
		for (Node n : list) {
			if (find(n.from) != find(n.to)) {
				sum += n.cost;
				union(n.from, n.to);
			}
		}
		
		System.out.println(sum);
		
	}
	
	static void union(int from, int to) {
		
		from = find(from);
		to = find(to);
		
		if (from != to) {
			parents[to] = from;
		}
		
	}

	static int find(int v) {
		
		if (parents[v] == v) {
			return v;
		}
		
		return parents[v] = find(parents[v]);
	}
	
	static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
}
