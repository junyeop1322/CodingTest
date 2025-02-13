import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	double x;
	double y;
	double w;

	Node(double x, double y, double w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return o.w >= this.w ? -1 : 1;
	}

}

public class Main {
	
	static int n;
	static ArrayList<Node> starList;
	static int[] parent;
	static double answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());

		Node[] star = new Node[n];
		parent = new int[n];
		starList = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
	
			star[i] = new Node(x, y, 0);
		}
		
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for(int i = 0; i < n-1; i++) {
			Node n1 = star[i];

			for(int j = i+1; j < n; j++) {
				Node n2 = star[j];

				double weight = Math.sqrt(Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2));
				starList.add(new Node(i, j, weight));
			}
		}
		
		Collections.sort(starList);
		
		for(int i = 0; i < starList.size(); i++) {
			Node node = starList.get(i);
			
			int start = (int) node.x;
			int end = (int) node.y;
			
			
			if(find(start) != find(end)) {
				union(start, end);
				answer += node.w;
			}
		}
		
		System.out.println(String.format("%.2f", answer));
	}

	static int find(int a) {
		if(a == parent[a])
			return a;

		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		parent[b] = a;
	}

}