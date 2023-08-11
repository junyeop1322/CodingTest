import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			
			return o1[1] - o2[1];
		});

//		int[] map = new int[arr[N - 1][1] + 1];
//		boolean[] check = new boolean[N];

//		int cnt = 0;
		
//		for (int i = 0; i < N; i++) {
//			for (int j = arr[i][0]; j < arr[i][1]; j++) {
//				if (map[j] == 1) {
//					check[i] = true;
//					continue;
//				}
//			}
//			
//			if (!check[i]) {
//				for (int j = arr[i][0]; j < arr[i][1]; j++) {
//					map[j] = 1;
//				}
//				cnt++;
//			}
//		}
		
		int t = 0;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i][0] >= arr[t][1]) {
				t = i;
				cnt++;
			}
//			System.out.println(t);
		}

//		for (int i = 0; i < map.length; i++) {
//			System.out.print(map[i] + " ");
//		}
//		System.out.println();
		System.out.println(cnt);
	}

}
