import java.util.Scanner;


public class Main {

	static int N;
	static int M;
//	static int[] arr;
	static boolean[] isSelec;
	static int[] res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
//		arr = new int[N];
		res = new int[N];
		
//		for (int i = 0; i < N; i++) {
//			arr[i] = i+1;
//		}

		isSelec = new boolean[N+1];
		perm(0);
		
		sc.close();
	}
	
	static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < cnt; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (isSelec[i] == false) {
				isSelec[i] = true;
				
				res[cnt] = i;
				
				perm(cnt+1);
				isSelec[i] = false;
				
			}
		}
		
	}

}
