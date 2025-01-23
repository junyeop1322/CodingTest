import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			max = Math.max(max, arr[i][1]);
		}
		
		int[] days = new int[max+1];
		
		Arrays.sort(arr, (o1, o2) -> {
			return o2[0] - o1[0];
		});
		

		for (int i = 0; i < n; i++) {
			int pay = arr[i][0];
			int day = arr[i][1];
			
			for (int j = day; j > 0; j--) {
				if (days[j] < pay) {
					days[j] = pay;
					break;
				}
			}
		}
		
		int ans = 0;
		
		for (int i = 1; i <= max; i++) {
			ans += days[i];
		}
		
		System.out.println(ans);
	}

}
