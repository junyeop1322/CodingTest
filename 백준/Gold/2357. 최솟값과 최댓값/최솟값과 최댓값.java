import java.io.*;
import java.util.*;


public class Main {
	
	static int n, min, max;
	static int[] arr;
	static int[] minTree, maxTree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int size = getTreeSize();
		minTree = new int[size];
		maxTree = new int[size];
		
		initTree(0, minTree, 1, n, 1);
		initTree(1, maxTree, 1, n, 1);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			findMinMax(0, minTree, 1, n, 1, a, b);
			findMinMax(1, maxTree, 1, n, 1, a, b);
			
			sb.append(min + " " + max + "\n");
		}
		
		System.out.println(sb);
	}
	
	static int getTreeSize() {
		int h = (int)Math.ceil(Math.log(n)/Math.log(2)) + 1;
		return (int)Math.pow(2, h);
	}
	
	static void initTree(int type, int[] tree, int start, int end, int node) {
		
		if (start == end) {
			tree[node] = arr[start];
		} else {
			int mid = (start+end) / 2;
			
			initTree(type, tree, start, mid, node*2);
			initTree(type, tree, mid+1, end, node*2+1);
			
			if (type == 0) {
				if (tree[node*2] < tree[node*2+1]) {
					tree[node] = tree[node*2];
				} else {
					tree[node] = tree[node*2+1];
				}
			} else {
				if (tree[node*2] > tree[node*2+1]) {
					tree[node] = tree[node*2];
				} else {
					tree[node] = tree[node*2+1];
				}
			}
		}
		
	}
	
	static void findMinMax(int type, int[] tree, int start, int end, int node, int l, int r) {
		if (l > end || r < start) {
			return;
		}
		
		if (l <= start && r >= end) {
			if (type == 0) {
				min = Math.min(min, tree[node]);
			} else {
				max = Math.max(max, tree[node]);
			}
			
			return;
		}
		
		int mid = (start+end) / 2;
		
		findMinMax(type, tree, start, mid, node*2, l, r);
		findMinMax(type, tree, mid+1, end, node*2+1, l, r);
		
	}

}
