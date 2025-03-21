import java.io.*;
import java.util.*;

public class Main {

	static int n, m, k, x;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		List<Integer>[] list = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		dist[x] = 0;
		
		List<Integer> ans = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if (dist[cur] > k) {
				break;
			}
			
			if (dist[cur] == k) {
				ans.add(cur);
			}
			
			for (int next : list[cur]) {
				if (dist[next] != -1) {
					continue;
				}
				
				dist[next] = dist[cur]+1;
				q.add(next);
			}
		}
		
		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		for (int num : ans) {
			sb.append(num).append("\n");
		}
		
		if (ans.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
	}

}
