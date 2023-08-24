import java.util.*;
import java.io.*;

public class Solution {
	
	public static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight -o.weight;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[v];

			List<Vertex>[] vList = new ArrayList[v];
			for (int i = 0; i < v; i++) {
				vList[i] = new ArrayList<Vertex>();
			}
			
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int cost = Integer.parseInt(st.nextToken());
				
				
				vList[x].add(new Vertex(y, cost));
				vList[y].add(new Vertex(x, cost));
			}
			
			PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
			
			long sum = 0;
			int cnt = 0;
			visited[0] = true;
			
			for (Vertex ver : vList[0]) {
				pq.add(ver);
			}
			
			while(!pq.isEmpty()) {
				Vertex cur = pq.poll();
				
				if (visited[cur.no]) continue;
				
				sum += cur.weight;
				
				visited[cur.no] = true;
				
				if (cnt++ == v-1) {
					break;
				}
				
				for(Vertex ver : vList[cur.no]) {
					if (visited[ver.no]) continue;
					
					pq.add(ver);
				}
				
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}

}
