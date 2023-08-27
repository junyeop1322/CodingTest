import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] brr = new int[n];
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken()); 
			arr[i] = num;
			brr[i] = num;
		}
		
		Arrays.sort(brr);
		
		int rank = 0;
		for (int i = 0; i < n; i++) {
			if (!hash.containsKey(brr[i])) {
				hash.put(brr[i], rank);
				rank++;
			}
		}
		
		for (int i = 0; i < n; i++) {
			int ans = hash.get(arr[i]);
			sb.append(ans).append(" ");
		}
	
		System.out.println(sb);
	}
}
