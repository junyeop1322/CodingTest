import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {

	int num;
	int idx;
	
	Node(int num, int idx) {
		this.num = num;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(Node o) {
		return num - o.num;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Node[] node = new Node[n+1];
		
		for(int i = 1; i <= n; i++) {
			int num = Integer.parseInt(br.readLine());
			node[i] = new Node(num, i);
		}
		Arrays.sort(node, 1, n+1);
		
		int max = 0;
		
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, node[i].idx - i);
		}
		
		System.out.println(max+1);
	}
	


}
