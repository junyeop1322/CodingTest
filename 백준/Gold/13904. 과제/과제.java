import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(list, (o1, o2) -> {
			return o1[0] - o2[0];
		});

		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int[] arr : list) {
			pq.add(arr[1]);
			
			if (pq.size() > arr[0]) {
				pq.poll();
			}
		}
		
		int ans = 0;
		for (int num : pq) {
			ans += num;
		}
		
		System.out.println(ans);
	}

}
