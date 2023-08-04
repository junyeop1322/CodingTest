import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stackInt = new Stack<>();
		
		int N = sc.nextInt();
		int sum = 0;
		
		for (int t = 0; t < N; t++) {
			int num = sc.nextInt();
			
			if (num != 0) {
				stackInt.push(num);
			} else {
				stackInt.pop();
			}
		}
		
		for (int i = 0; i < stackInt.size(); i++) {
			sum += stackInt.get(i);
		}
		
		System.out.println(sum);
	}

}
