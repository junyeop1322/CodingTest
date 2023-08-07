import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static int[] res;
	static boolean[] isSelec;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		res = new int[M];
		isSelec = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		perm(0);

		sc.close();
	}

	static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelec[i] == false) {
				isSelec[i] = true;
				res[cnt] = arr[i];

				perm(cnt + 1);
				isSelec[i] = false;
			}
		}
	}

}
