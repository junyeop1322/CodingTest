import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int res = 0;
		List<Integer> lst = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int num = i;
			int sum = 0;
			while (num != 0) {
				sum += num % 10;
				num /= 10;
			}

			if (sum + i == N) {
				res = i;
				
				lst.add(res);
				break;
			}
		}
		
//		System.out.println(res);

		if (lst.size() == 0) {
			System.out.println(0);
		} else {
			int[] arr = new int[lst.size()];

			for (int i = 0; i < lst.size(); i++) {
				arr[i] = lst.get(i);
			}

			Arrays.sort(arr);

			System.out.println(arr[0]);
		}
		
		sc.close();
	}

}
