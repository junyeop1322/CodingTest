//import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
//		int[] ans = new int[M];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			int sum = 0;
			for (int i = sx; i <= ex; i++) {
				sum += (arr[i][ey] - arr[i][sy - 1]);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);

		
//		for (int i = 0; i < ans.length; i++) {
//			System.out.println(ans[i]);
//		}
//		sc.close();
	}
}
