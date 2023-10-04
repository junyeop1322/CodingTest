import java.io.*;
import java.util.*;

public class Main {
	
	public static class Node {
		int idx;
		int time;
		
		public Node(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
	}

	static int n, k, ans;
	static int[] map;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[100001];
		visit = new boolean[100001];
		ans = Integer.MAX_VALUE;

		bfs();
		
		System.out.println(ans);
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n, 0));

		while (!q.isEmpty()) {
			Node now = q.poll();
			int num = now.idx;
			int t = now.time;
			visit[num] = true;
			
			if (num == k) {
				ans = Math.min(ans, t);
			}
			
			
			if (num-1 >= 0) {
				if (!visit[num-1]) {
					q.add(new Node(num-1, t+1));
				}
			}
			
			if (num+1 < 100001) {
				if (!visit[num+1]) {
					q.add(new Node(num+1, t+1));
				}
			}
			
			if (num*2 < 100001) {
				if (!visit[num*2]) {
					q.add(new Node(num*2, t));
				}
			}
			
		}

	}

}
