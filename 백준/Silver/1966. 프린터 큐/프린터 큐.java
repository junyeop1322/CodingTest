import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n][2];
			int[] brr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i][0] = i;
				arr[i][1] = Integer.parseInt(st.nextToken());
				brr[i] = arr[i][1];
			}
			
			Arrays.sort(brr);
			
			Queue<int[]> q = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				q.add(arr[i]);
			}
			
			int cnt = 0;
			int find = n-1;
			while (!q.isEmpty()) {
				if (q.peek()[1] == brr[find]) {
					cnt++;
					if (q.peek()[0] == m) {
						break;
					}
					find--;
					q.poll();
				} else {
					q.add(q.poll());
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}
