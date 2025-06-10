import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[m+1];
		
		Arrays.fill(arr, -1);
		arr[s] = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			int v = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new ArrayList<>();
			
			for (int j = 0; j <= m; j++) {
				if (arr[j] == i-1) {
					int num1 = j + v;
					int num2 = j - v;
					
					if (0 <= num1 && num1 <= m) {
						list.add(num1);
					}
					
					if (0 <= num2 && num2 <= m) {
						list.add(num2);
					}
				}
			}
			
			for (int num : list) {
				arr[num] = i;
			}
		}
		
		int ans = -1;
		for (int i = 0; i <= m; i++) {
			if (arr[i] == n) {
				ans = Math.max(ans, i);
			}
		}

		System.out.println(ans);
	}

}
