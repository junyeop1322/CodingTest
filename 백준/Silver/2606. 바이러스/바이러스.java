import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[] visit;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		visit = new int[n+1];
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; i++ ) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		dfs(1);
		
		int ans = -1;
		for (int i = 1; i < visit.length; i++) {
			if (visit[i] == 1) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	static void dfs(int node) {
		visit[node] = 1;
		
		for (int i = 0; i < graph.get(node).size(); i++) {
			int nNode = graph.get(node).get(i);
			if (visit[nNode] == 0) {
				dfs(nNode);
			}
		}
	}
}
