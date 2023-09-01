import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[] visit;
	static boolean[] truePeople = new boolean[51];
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

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			if (a > b) {
				parents[a] = b;
			} else {
				parents[b] = a;
			}
			return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		make();
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++) {
			truePeople[Integer.parseInt(st.nextToken())] = true;
		}
		
		ArrayList<Integer>[] peoples = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			peoples[i] = new ArrayList<>();
		}
		
		int val, pre = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			if (num > 0) {
				pre = Integer.parseInt(st.nextToken());
				peoples[i].add(pre);
			}
			
			for (int j = 1; j < num; j++) {
				val = Integer.parseInt(st.nextToken());
				peoples[i].add(val);
				union(pre, val);
				pre = val;
			}
		}
		
		int paren;
		for (int i = 1; i < truePeople.length; i++) {
			if (truePeople[i]) {
				truePeople[find(i)] = true;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < m; i++) {
			if (peoples[i].size() > 0) {
				paren = find(peoples[i].get(0));
				if (!truePeople[paren]) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);

	}

}
