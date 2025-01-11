import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node> {
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.weight - n.weight;
		}
	}
	
	static int n, m;
	static int start, end;
	static List<ArrayList<Node>> graph;
	static int[] d, perCity;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		d = new int[n+1];
		perCity = new int[n+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Node(to, weight));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(d[end]);
		
		int cnt = 0;
		Stack<Integer> stk = new Stack<>();
		stk.push(end);
		while(perCity[end] != 0) {
			cnt += 1;
			stk.push(perCity[end]);
			end = perCity[end];
		}
		
		System.out.println(cnt+1);
		
		while(!stk.isEmpty()) {
			System.out.print(stk.pop() + " ");
		}
	}
	
	static void dijkstra(int start) {
		Queue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			int curTo = cur.to;
			if (d[curTo] < cur.weight) {
				continue;
			}
			
			for (Node next : graph.get(curTo)) {
				if (d[next.to] > d[curTo] + next.weight) {
					d[next.to] = d[curTo] + next.weight;
					perCity[next.to] = curTo;
					pq.add(new Node(next.to, d[next.to]));
				}
			}
		}
		
	}

}
