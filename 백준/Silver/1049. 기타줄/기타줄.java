import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		Scanner sc = new Scanner(System.in);

//		st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[M][2];

//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; i < 2; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int num = N;
		int ans = 0;

		Arrays.sort(arr, (o1, o2) -> {
			return o1[0] - o2[0];
		});
		int six = arr[0][0];

		Arrays.sort(arr, (o1, o2) -> {
			return o1[1] - o2[1];
		});
		int one = arr[0][1];
		
		if (num >= 6) {
			if (six < one*6) {
				ans += six * (num/6);
				num = num % 6;
			} else {
				ans = one * num;
				num = 0;
			}
		}
		
		if (num != 0) {
			if (six < one*num) {
				ans += six;
			} else {
				ans += one * num;
			}
		}

		System.out.println(ans);
	}

}
