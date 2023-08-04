import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<>();
		
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		
		for (int i = 0; i < N -1; i++) {
			que.poll();
			
			que.offer(que.poll());
		}
		
		System.out.println(que.poll());
	}

}
