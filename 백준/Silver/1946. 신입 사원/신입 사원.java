import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 1;
			
			Arrays.sort(arr, (o1, o2) -> {
				return (o1[0] - o2[0]);
			});
			
			int pivot = arr[0][1];
			for (int i = 1; i < n; i++) {
				if (arr[i][1] < pivot) {
					pivot = arr[i][1];
					cnt++;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}
