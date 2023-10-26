import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int candy[], w, cnt;
	static ArrayList<Integer> list[];
	static ArrayList<Node> node;
	static boolean[] visit;
	
	static class Node {
		int w;
		int cnt;
		
		public Node(int cnt, int w) {
			this.cnt = cnt;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		candy = new int[N+1];
		visit = new boolean[N+1];
		list = new ArrayList[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		node = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				w = 0;
				cnt = 0;
				dfs(i);
				
				node.add(new Node(cnt, w));
			}
		}
		
		int[][] dp = new int[2][K];
		for (Node n : node) {
			for (int i = 0; i < K; i++) {
				if (i >= n.cnt) {
					dp[1][i] = Math.max(dp[0][i], dp[0][i-n.cnt]+n.w);
				} else {
					dp[1][i] = dp[0][i];
				}
			}
			
			for (int i = 0; i < K; i++) {
				dp[0][i] = dp[1][i];
			}
		}
		
		System.out.println(dp[1][K-1]);
 	}
	
	static void dfs(int num) {
		visit[num] = true;
		w += candy[num];
		cnt += 1;
		
		for (int tmp : list[num]) {
			if (visit[tmp]) {
				continue;
			}
			
			dfs(tmp);
		}
	}

}
