import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i != j) {
					for (int k = 0; k < N; k++) {
						if(k != i && k != j) {
							if(arr[i] + arr[j] + arr[k] <= M) {
								if (arr[i] + arr[j] + arr[k] > max) {
									max = arr[i] + arr[j] + arr[k];
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}

}
