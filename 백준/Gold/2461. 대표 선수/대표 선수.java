import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			Arrays.sort(map[i]);
		}
		
		int ans = Integer.MAX_VALUE;
		int num = 0;
		
		while(true) {
			int max = 0;
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				if (map[i][arr[i]] > max) {
					max = map[i][arr[i]];
				}
				
				if (map[i][arr[i]] < min) {
					min = map[i][arr[i]];
					num = i;
				}
			}
			
			ans = Math.min(ans, max - min);
			arr[num]++;
			
			if (arr[num] == m) {
				break;
			}
		}
		
		System.out.println(ans);
	}

}
