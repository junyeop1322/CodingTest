import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static int[] res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		res = new int[M];
		
		for (int i =0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		comb(0, 0);
		
		sc.close();
	}
	
	static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < N; i++) {
			res[cnt] = arr[i];
			
			comb(cnt+1, i+1);
		}
	}

}
