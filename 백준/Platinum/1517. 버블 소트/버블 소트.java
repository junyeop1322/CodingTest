import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static long[] elements, index, tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		elements = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			elements[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(elements[i], i);
		}
		
		index = elements.clone();
		Arrays.sort(index);
		
		tree = new long[getTreeSize()];
		long ans = 0;
		
		for (int i = 0; i < n; i++) {
			int idx = map.get(index[i]);
			ans += sum(0, n-1, 1, idx+1, n-1);
			update(0, n-1, 1, idx, 1);
		}
		
		System.out.println(ans);
	}
	
	static int getTreeSize() {
		int h = (int)Math.ceil(Math.log(n)/Math.log(2)) + 1;
		return (int)Math.pow(2, h) - 1;
	}
	
	static long sum(int start, int end, int node, int left, int right) {
		if (end < left || right < start) {
			return 0;
		}
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end) / 2;
		
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}
	
	static void update(int start, int end, int node, int idx, int dif) {
		if (start == end) {
			tree[node] = dif;
			return;
		}
		
		int mid = (start + end) / 2;
		if (idx <= mid) {
			update(start, mid, node*2, idx, dif);
		} else {
			update(mid+1, end, node*2+1, idx, dif);
		}
		
		tree[node] = tree[node*2] + tree[node*2+1];
	}

}
