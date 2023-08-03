import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			int sum = 0;
			int avg = 0;
			
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			
			avg = sum / n;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] > avg) {
					cnt++;
				}
			}
			
			float ans = ((float)cnt / (float)n) * 100;
			
			System.out.printf("%.3f", ans);
			System.out.println("%");
		}
	}

}
