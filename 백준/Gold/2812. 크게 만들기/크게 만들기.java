import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		char[] arr = new char[n];
		String str = br.readLine();
		for (int i = 0; i < n; i++) {
			arr[i] = str.charAt(i);
		}
		
		Deque<Character> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			while(k > 0 && !dq.isEmpty() && dq.getLast() < arr[i]) {
				dq.removeLast();
				k--;
			}
			
			dq.addLast(arr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		while(dq.size() > k) {
			sb.append(dq.removeFirst());
		}

		System.out.println(sb);
	}

}
