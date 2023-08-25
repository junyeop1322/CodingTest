import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] color;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			color = new int[n+1];

			graph = new ArrayList<>();
			
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			
			boolean check = false;
			for (int i = 1; i <= n ; i++) {
				if (color[i] == 0) {
					check = bfs(i, 1);
				}
				if (!check) {
					break;
				}
			}
			
			if (check) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}

		}

		System.out.println(sb);
	}

	static boolean bfs(int start, int col) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		color[start] = col;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph.get(cur)) {
				if (color[cur] == color[next]) {
					return false;
				}
				
				if (color[next] == 0) {
					color[next] = color[cur] * -1;
					q.add(next);
				}
			}
		}
		
		return true;
	}
	
}
