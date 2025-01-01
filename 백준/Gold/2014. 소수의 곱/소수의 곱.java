import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long[] prime = new long[k];
		Queue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
			prime[i] = Long.parseLong(st.nextToken());
			pq.add(prime[i]);
		}
		
		for (int i = 0; i < n-1; i++) {
			long num = pq.poll();
			
			for (int j = 0; j < k; j++) {
				pq.add(num * prime[j]);
				
				if (num % prime[j] == 0) {
					break;
				}
			}
		}
		
		System.out.println(pq.poll());
	}

}

