import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[5][4];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int[] point = new int[5];
		int max = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				point[i] += arr[i][j];
			}
			if (point[i] > max) {
				max = point[i];
			}
		}
		
		for (int i = 0; i < 5; i++) {
			if (max == point[i]) {
				System.out.printf("%d %d", i+1, point[i]);
			}
		}
	}

}
