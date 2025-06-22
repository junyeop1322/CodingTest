import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parents;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (find(x) == find(y)) {
				System.out.println(i+1);
				return;
			} else {
				union(x, y);
			}
		}
		
		System.out.println(0);
	}
	
	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		
		return parents[x] = find(parents[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a < b) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}

}
