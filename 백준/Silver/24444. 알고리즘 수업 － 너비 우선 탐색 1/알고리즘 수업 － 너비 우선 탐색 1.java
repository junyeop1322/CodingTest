import java.util.*;
import java.io.*;

public class Main {

	static int n, cnt;
	static int[] checked;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		checked = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list.get(u).add(v);
			list.get(v).add(u);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(list.get(i));
		}
		cnt = 1;
		bfs(r);
		
		for(int i = 1; i < checked.length; i++) {
			sb.append(checked[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int node) {
		Queue<Integer> que = new LinkedList<>();
		checked[node] = cnt++;
		que.offer(node);
		
		while (!que.isEmpty()) {
			int newNode = que.poll();
			for (int i = 0; i < list.get(newNode).size(); i++) {
				int check = list.get(newNode).get(i);
				if (checked[check] == 0) {
					que.offer(check);
					checked[check] = cnt++;
				}
			}
		}
	}

}
