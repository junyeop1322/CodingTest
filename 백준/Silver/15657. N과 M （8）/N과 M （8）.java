import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		comb(0, 0);
	}

	static void comb(int cnt, int start) {
		if (cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < N; i++) {
			res[cnt] = arr[i];
			
			comb(cnt+1, i);
		}
	}
}
