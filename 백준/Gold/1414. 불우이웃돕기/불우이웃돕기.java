import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int to;
		int from;
		int v;
		
		public Node(int to, int from, int v) {
			this.to = to;
			this.from = from;
			this.v = v;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.v - o.v;
		}
	}
	
	static int n;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		parents = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
		int sum = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ('a' <= map[i][j] && map[i][j] <= 'z') {
					sum += map[i][j] - 96;
					pq.add(new Node(i+1, j+1, map[i][j]-96));
				} else if ('A' <= map[i][j] && map[i][j] <= 'Z') {
					sum += map[i][j] - 38;
					pq.add(new Node(i+1, j+1, map[i][j]-38));
				}
			}
		}
		
		int size = pq.size();
		int num = 1;
		int ans = 0;
		
		for (int i = 0; i < size; i++) {
			Node cur = pq.poll();
			int nx = find(cur.to);
			int ny = find(cur.from);
			
			if (nx != ny) {
				num++;
				ans += cur.v;
				union(cur.to, cur.from);
			}
		}
		
		if (num != n) {
			System.out.println(-1);
		} else {
			System.out.println(sum - ans);
		}

	}
	
	static int find(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			return parents[x] = find(parents[x]);
		}
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x < y) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
	}
}
