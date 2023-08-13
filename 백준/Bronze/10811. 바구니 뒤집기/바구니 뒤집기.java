import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken()) - 1;
			
			while (n < m) {
				int temp = arr[n];
				arr[n] = arr[m];
				arr[m] = temp;
				n++;
				m--;
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
