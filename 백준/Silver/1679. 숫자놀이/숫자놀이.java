import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		int max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		m = Integer.parseInt(br.readLine());
		
		int[] memo = new int[max*m + + 1 + 1];
		for (int i = 1; i < memo.length; i++) {
			memo[i] = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if(arr[j] <= i) {
					memo[i] = Math.min(memo[i], memo[i-arr[j]]+1);
				}
			}
			
			if (memo[i] > m) {
				if (i % 2 ==0) {
					sb.append("holsoon");
				} else {
					sb.append("jjaksoon");
				}
				sb.append(" win at " + i + "\n");
				break;
			}
		}

		System.out.println(sb);
	}

}
