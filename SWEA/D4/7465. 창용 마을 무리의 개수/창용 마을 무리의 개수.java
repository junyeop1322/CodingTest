import java.io.*;
import java.util.*;

public class Solution {
	
	static int n, m;
	static int[] parents;
	
	static void make() {
		parents = new int[n+1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parents[a] = b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			make();
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			for (int i = 0; i <= n; i++) {
				find(i);
			}

			Arrays.sort(parents);

			int cnt = 1;
			for (int i = 1; i < n; i++) {
				if (parents[i] != parents[i+1]) {
					cnt++;
				}
			}
			
//			for (int i = 1; i <= n; i++) {
//				System.out.print(parents[i] + " ");
//			}
//			System.out.println();
			
			System.out.println("#" + t + " "+ cnt);
		}
		
	}

}
