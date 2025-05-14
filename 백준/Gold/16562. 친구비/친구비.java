import java.io.*;
import java.util.*;

public class Main {
	
	static int[] cost;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		cost = new int[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a > b) {
				union(b, a);
			} else {
				union(a, b);
			}
		}
		
		long cnt = 0;
		boolean[] check = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			int idx = find(i);
			
			if (!check[idx]) {
				cnt += cost[idx];
				check[idx] = true;
			}
			
			check[i] = true;
		}
		
		if (cnt > k) {
			System.out.println("Oh no");
		} else {
			System.out.println(cnt);
		}
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (cost[a] > cost[b]) {
			parents[a] = b;
		} else {
			parents[b] = a;
		}
		
	}
	
	static int find(int x) {
		if (x == parents[x]) {
			return x;
		}
		
		return parents[x] = find(parents[x]); 
	}

}
