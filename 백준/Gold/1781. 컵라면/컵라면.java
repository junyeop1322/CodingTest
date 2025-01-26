import java.io.*;
import java.util.*;

public class Main {

	static int n;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (map.containsKey(a)) {
				map.get(a).add(b);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(b);
				map.put(a, list);
			}
		}
		
		List<Integer> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		
		Queue<Integer> pq = new PriorityQueue<>();
		for (int i : keySet) {
			for (int j : map.get(i)) {
				pq.add(j);
				while(pq.size() > i) {
					pq.poll();
				}
			}
		}
		
		int ans = 0;
		
		while(!pq.isEmpty()) {
			ans += pq.poll();
		}
		
		System.out.println(ans);
	}

}
