import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
		
		int ans = 0;
		int tmp = 0;
		
		Queue<Integer> q2 = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			q2.add(0);
		}
		
		while(!q2.isEmpty()) {
			ans++;
			tmp -= q2.poll();
			
			if (!q.isEmpty()) {
				if (q.peek() + tmp <= l) {
					tmp += q.peek();
					q2.add(q.poll());
				} else {
					q2.add(0);
				}
			}
		}

		System.out.println(ans);
	}

}
