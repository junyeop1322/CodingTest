import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[] parents;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		parents = new int[n*m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				parents[i*m + j] = i*m + j;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int nx = i;
				int ny = j;
				
				if (map[i][j] == 'U') {
					nx--;
				} else if (map[i][j] == 'D') {
					nx++;
				} else if (map[i][j] == 'R') {
					ny++;
				} else {
					ny--;
				}
				union(i*m+j, nx*m+ny);
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				set.add(find(i*m+j));
			}
		}
		
		System.out.println(set.size());
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
	
	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		
		return parents[x] = find(parents[x]);
	}

}
