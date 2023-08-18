import java.util.*;
import java.io.*;

public class Main {

	static int n, m, cntD, cntB;
//	static ArrayList<Integer> checkDFS;
	static int[] checkBFS;
	static int[] checkDFS;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		checkDFS = new int[n + 1];
//		checkDFS = new ArrayList<Integer>();
		checkBFS = new int[n + 1];

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
		
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}

		cntD = 1;
		cntB = 1;
		dfs(r);
		bfs(r);

//		for (int i = 0; i < checkDFS.size(); i++) {
//			sb.append(checkDFS.get(i)).append(" ");
//		}
//		for (int i = 1; i <= n; i++) {
//			sb.append(checkDFS[i]).append(" ");
//		}
//		sb.append("\n");
		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= n; i++) {
				if (checkDFS[i] == j) {
					sb.append(i).append(" ");
				}
			}
		}

		sb.append("\n");
		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= n; i++) {
				if (checkBFS[i] == j) {
					sb.append(i).append(" ");
				}
			}
		}
//		int B = 1;
//		for (int i = 1; i <= n; i++) {
//			if (checkBFS[i] == B) {
//				sb.append(i).append(" ");
//			}
//			B++;
//		}

		System.out.println(sb);
	}

	static void dfs(int node) {
		checkDFS[node] = cntD;
//		checkDFS.add(node);

		for (int i = 0; i < graph.get(node).size(); i++) {
			int newNode = graph.get(node).get(i);
			if (checkDFS[newNode] == 0) {
				cntD++;
				dfs(newNode);
			}
//			boolean visit = true;
//			for (int k = 0; k < checkDFS.size(); i++) {
//				if (checkDFS.get(k) == newNode) {
//					visit = false;
//				}
//			}
//			if (visit) {
////				cntD++;
//				dfs(newNode);
//			}
		}
	}

	static void bfs(int node) {
		Queue<Integer> que = new LinkedList<>();
		checkBFS[node] = cntB++;

		que.offer(node);
		while (!que.isEmpty()) {
			int newNode = que.poll();
			for (int i = 0; i < graph.get(newNode).size(); i++) {
				int next = graph.get(newNode).get(i);
				if (checkBFS[next] == 0) {
					checkBFS[next] = cntB++;
					que.offer(next);
				}
			}
		}
	}

}
