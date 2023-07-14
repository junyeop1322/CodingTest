import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		long sum = 0;
		long max = 0;
		
		for(int i = 0; i < N; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
			sum += arr[i];
		}
		
		double ans = sum * 100.0 / N / max;
		
		System.out.println(ans);

	}

}