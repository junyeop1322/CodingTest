import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] ans = new int[N];
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K-1; j++) {
				q.offer(q.poll());
			}
			ans[i] = q.poll();
		}
		
		System.out.print("<");
		for (int i = 0; i < N-1; i++) {
			System.out.print(ans[i] + ", ");
		}
		System.out.print(ans[N-1]);
		System.out.print(">");
		sc.close();
	}

}
