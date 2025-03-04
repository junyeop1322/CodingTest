import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()) - 1;
		int m = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int cnt = 0;
		
		while(!pq.isEmpty() && pq.peek() >= m) {
			m++;
			pq.add(pq.poll()-1);
			cnt++;
		}

		System.out.println(cnt);
	}

}
