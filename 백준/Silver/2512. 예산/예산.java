import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		int num = Integer.parseInt(br.readLine());
		
		int ans = num / n;
		
		while(true) {
			int sum = 0;
			int cnt = 0;
			
			for (int i = 0; i < n; i++) {
				if (arr[i] <= ans) {
					sum += arr[i];
				} else {
					sum += ans;
					cnt++;
				}
			}
			if (cnt == 0) {
				ans = max;
				break;
			}
			
			if (sum > num) {
				ans = ans-1;
				break;
			}
			ans++;
			
		}
		
		System.out.println(ans);
	}

}
