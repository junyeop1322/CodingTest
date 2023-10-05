import java.io.*;

public class Main {
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		parent = new int[G+1];
		for (int i = 1; i <= G; i++) {
			parent[i] = i;
		}
		
		int cnt = 0;
		
		for (int i = 0; i < P; i++) {
			int num = Integer.parseInt(br.readLine());
			
			int gate = find(num);
			
			if (gate == 0) {
				break;
			}
			
			cnt++;
			union(gate, gate-1);
			
		}
		
		
		System.out.println(cnt);
	}
	
	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[x] = y;
		}
	}

}
