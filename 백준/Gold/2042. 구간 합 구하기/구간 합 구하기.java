import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, k;
	static long[] arr, tree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new long[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		tree = new long[n*4];
		
		init(1, n, 1);
		
		for (int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				long dif = c - arr[b];
				update(1, n, 1, b, dif);
				arr[b] = c;
			} else if (a == 2) {
				sb.append(sum(1, n, 1, b, (int)c) + "\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static long init(int s, int e, int node) {
		if (s == e) {
			return tree[node] = arr[s];
		}
		
		int mid = (s + e) / 2;
		
		return tree[node] = init(s, mid, node*2) + init(mid+1, e, node*2 + 1);
	}
	
	static long sum (int s, int e, int node, int l, int r) {
		if (l > e || r < s) {
			return 0;
		}
		
		if (l <= s && e <= r) {
			return tree[node];
		}
		
		int mid = (s + e) / 2;
		
		return sum(s, mid, node*2, l, r) + sum(mid+1, e, node*2+1, l, r);
	}

	static void update(int s, int e, int node, int idx, long dif) {
		if (idx < s || idx > e) {
			return;
		}
		
		tree[node] += dif;
		if (s == e) {
			return;
		}
		
		int mid = (s + e) / 2;
		update(s, mid, node*2, idx, dif);
		update(mid+1, e, node*2+1, idx, dif);
	}
}
