import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static boolean[] visited;
	static List<Integer>[] graph;
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1][2];
		visited = new boolean[n+1];
		graph = new ArrayList[n+1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph[s].add(e);
			graph[e].add(s);
		}
		
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	
	static void dfs(int num) {
		visited[num] = true;
		dp[num][0] = 0;
		dp[num][1] = 1;
		
		for (int m : graph[num]) {
			if (!visited[m]) {
				dfs(m);
				dp[num][0] += dp[m][1];
				dp[num][1] += Math.min(dp[m][0], dp[m][1]);
			}
		}
		
		
	}

}
