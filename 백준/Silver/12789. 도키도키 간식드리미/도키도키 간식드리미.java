import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> snack = new Stack<>();
		Queue<Integer> que = new LinkedList<>();
		
		int N = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		
		for (int t = 0; t < N; t++) {
			int num = sc.nextInt();
			que.offer(num);
		}
		
		while(true) {
			if (!(que.isEmpty())) {
				if (snack.isEmpty()) {
					snack.push(que.poll());
				} else {
					if (snack.peek() > que.peek()) {
						snack.push(que.poll());
					} else {
						arr.add(snack.pop());
					}
				}
			} else {
				if (!(snack.isEmpty())) {
					arr.add(snack.pop());					
				} else {
					break;
				}
			}
		}
		
		int[] ans = new int[N];
		for (int i = 0; i < N; i++) {
			ans[i] = i+1;
		}
		
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			result[i] = arr.get(i);
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (ans[i] == result[i]) {
				cnt++;
			}
		}
		
		
		if (N == cnt) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}

}
