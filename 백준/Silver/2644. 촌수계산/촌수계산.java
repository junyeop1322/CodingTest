import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] visit;
	static int n, m, a, b;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		visit = new int[n+1];
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);			
		}
		
		bfs(a);
		int ans = visit[b] - 1;
		System.out.println(ans);
	}
	
	static void bfs(int a) {
		Queue<Integer> que = new LinkedList<>();
		visit[a] = 1;
		que.offer(a);
		
		while (!que.isEmpty()) {
			int num = que.poll();
			for (int i = 0; i < graph.get(num).size(); i++) {
				int nNum = graph.get(num).get(i);
				if (visit[nNum] == 0) {
					que.offer(nNum);
					visit[nNum] = visit[num]+1;
				}
				
			}
			
		}
	}
	
}
