import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int max = 0;
		int a = 0;
		int b = 1;
		while (true) {
			if (arr[a] > arr[b]) {
				cnt++;
				b = b+1;
				if (b == n) {
					max = Math.max(max, cnt);
				}
			} else {
//				System.out.println(arr[a]);
//				System.out.println(arr[b]);
				a = b;
				b = b+1;
				
				max = Math.max(max, cnt);
				cnt = 0;
			}
			
			if (b == n) {
				break;
			}
		}
		
		System.out.println(max);
	}

}
