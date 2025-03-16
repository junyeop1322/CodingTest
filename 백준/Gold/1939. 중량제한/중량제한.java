import java.io.*;
import java.util.*;

public class Main {

	static class City {
		int to;
		int w;
		
		public City(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
	
	static int n, m, cnt;
	static List<City>[] list;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for (int i = 1; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int left = 0;
		int right = 0;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new City(b, c));
			list[b].add(new City(a, c));
			right = Math.max(right, c);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		while(left <= right) {
			int mid = (left + right) / 2;
			cnt = -1;
			
			check = new boolean[n+1];
			dfs(from, to, mid);
			
			if (cnt != -1) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}

		System.out.println(right);
	}
	
	static void dfs(int pos, int target, int limit) {
		if (pos == target) {
			cnt = pos;
			return;
		}
		
		check[pos] = true;
		for (City city : list[pos]) {
			if (!check[city.to] && limit <= city.w) {
				dfs(city.to, target, limit);
			}
		}
	}

}
