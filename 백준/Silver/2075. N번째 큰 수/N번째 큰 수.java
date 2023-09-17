import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < n-1; i++) {
			pq.poll();
		}
		
		System.out.println(pq.poll());
		
	}

}
