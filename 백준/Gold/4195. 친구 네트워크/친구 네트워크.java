import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;
	static int[] lev;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			parent = new int[n*2];
			lev = new int[n*2];
			
			for (int i = 0; i < n*2; i++) {
				parent[i] = i;
				lev[i] = 1;
			}
			
			int idx = 0;
			Map<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String a = st.nextToken();
				String b = st.nextToken();
				
				if (!map.containsKey(a)) {
					map.put(a, idx++);
				}
				
				if (!map.containsKey(b)) {
					map.put(b, idx++);
				}
				
				sb.append(union(map.get(a), map.get(b))).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static int union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[y] = x;
			lev[x] += lev[y];
			
			lev[y] = 1;
		}
		
		return lev[x];
	}
	
	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}

}
