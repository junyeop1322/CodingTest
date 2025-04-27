import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static List<Integer>[] graph;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		visited = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		bfs(1);

		for (int i = 2; i <= n; i++) {
			System.out.println(visited[i]);
		}
	}
	
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int tmp : graph[cur]) {
				if (visited[tmp] == 0) {
					visited[tmp] = cur;
					q.add(tmp);
				}
			}
		}
	}

}
