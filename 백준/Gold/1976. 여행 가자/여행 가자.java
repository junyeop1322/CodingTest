import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] parents;

	static void make() {
		parents = new int[n + 1];
		for (int i = 0; i <= n; i++) {
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
			if (a < b) {
				parents[b] = a;
			} else {
				parents[a] = b;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		make();

		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					union(i+1, j+1);
				}
			}
		}
		
		for (int i = 0; i < n+1; i++) {
			find(i);
		}

		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean check = true;
		for (int i = 0; i < m-1; i++) {
			if (find(arr[i]) != find(arr[i+1])) {
				check = false;
			}
		}
//		System.out.println(Arrays.toString(parents));

		if (check) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}

}
