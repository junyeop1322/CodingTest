import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] parents;

	static void make() {
		for (int i = 0; i < n + 1; i++) {
			parents[i] = i;
		}
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

		if (a != b) {
			if (b < a) {
				parents[a] = b;
//				System.out.println(1);
//				System.out.println(a + " " + b);
			} else {
				parents[b] = a;
//				System.out.println(2);
//				System.out.println(a + " " + b);
			}
		}
	}

	static boolean check(int a, int b) {
		a = find(a);
		b = find(b);

//		System.out.println(rootA);
//		System.out.println(rootB);
		
		if (a == b) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parents = new int[n + 1];
		make();

//		for (int i = 0; i <= n; i++) { 
//			System.out.print(parents[i] + " ");
//		}
//		System.out.println();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (type == 0) {
				union(a, b);
			} else {
//				for (int j = 0; j <= n; j++) { 
//					System.out.print(parents[j] + " ");
//				}
//				System.out.println();
				if (check(a, b)) {
					sb.append("NO\n");
				} else {
					sb.append("YES\n");
				}
			}
		}

//		for (int i = 0; i <= n; i++) { 
//			System.out.print(parents[i] + " ");
//		}
//		System.out.println();
		System.out.println(sb); 
	}

}
