import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+2];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int idx = 0;
		
		while(true) {
			if (idx >= n) {
				break;
			}
			
			int num = arr[idx];
			
			if (num > 0) {
				ans += num * 3;
				num = Math.min(num, arr[idx+1]);
				
				ans += num * 2;
				arr[idx+1] -= num;
				num = Math.min(num, arr[idx+2] - Math.min(arr[idx+1], arr[idx+2]));
				
				ans += num * 2;
				arr[idx+2] -= num;
			}
			
			idx++;
		}

		System.out.println(ans);
	}

}
