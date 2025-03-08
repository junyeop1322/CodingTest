import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] list1 = new int[n];
		int[] list2 = new int[n];
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			list1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			list2[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] list3 = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			list3[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (list1[i] == 0) {
				dq.addFirst(list2[i]);
			}
		}
		
		for (int i = 0; i < m; i++) {
			dq.add(list3[i]);
			sb.append(dq.pollFirst() + " ");
		}
		
		System.out.println(sb.toString());
	}

}
