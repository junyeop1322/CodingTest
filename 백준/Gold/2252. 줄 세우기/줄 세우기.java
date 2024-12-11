import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] count = new int[n+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			count[b]++;
		}
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			if(count[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for (int next : graph.get(cur)) {
				count[next]--;
				if (count[next] == 0) {
					q.add(next);
				}
			}
		}
		
		System.out.println(sb);

	}

}
