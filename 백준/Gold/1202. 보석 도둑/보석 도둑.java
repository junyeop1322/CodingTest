import java.io.*;
import java.util.*;

class Juwel implements Comparable<Juwel> {
	int m;
	int v;
	
	public Juwel(int m, int v) {
		this.m = m;
		this.v = v;
	}

	@Override
	public int compareTo(Juwel o) {
		return this.m - o.m;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] bag = new int[k];
		List<Juwel> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.add(new Juwel(m, v));
		}
		
		for (int i = 0; i < k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bag);
		Collections.sort(list);

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			return o2 - o1;
		});
		
		long ans = 0;
		int j = 0;
		
		for (int i = 0; i < k; i++) {
			while(true) {
				if (j >= n) {
					break;
				}
				
				Juwel jew = list.get(j);
				
				if (bag[i] < list.get(j).m) {
					break;
				}
				
				pq.add(jew.v);
				j++;
			}
			
			if (!pq.isEmpty()) {
				ans += Math.abs(pq.poll());
			}
		}
		
		
		System.out.println(ans);
	}

}
