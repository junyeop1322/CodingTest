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
			return this.cost - o.cost;
		}
		
	}
	
	static int V, E;
	static int[] parents;
	static ArrayList<Node> nodeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V+1];
		nodeList = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			nodeList.add(new Node(from, to, cost));
		}
		
		Collections.sort(nodeList);
		
		make();
		
		int sum = 0;
		int cnt = 0;
		
		for (Node n : nodeList) {
			if (union(n.from, n.to)) {
				sum += n.cost;
				cnt++;
			}
			
			if (cnt == E-1) {
				break;
			}
		}
		
		System.out.println(sum);
	}

	static boolean union(int from, int to) {
		
		from = find(from);
		to = find(to);
		
		if (from == to) {
			return false;
		} else {
			parents[to] = from;
		}
		
		return true;
	}
	
	static int find(int v) {
		if (parents[v] == v) {
			return v;
		}
		
		return parents[v] = find(parents[v]);
	}
	
	static void make() {
		for(int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
}
