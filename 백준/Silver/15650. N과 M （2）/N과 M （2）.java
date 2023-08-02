import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[] res;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		res = new int[M];
		
		comb(0, 1);
	}
	
	static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < res.length; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <= N; i++) {
			res[cnt] = i;
			
			comb(cnt+1, i+1);
		}
	}

}
