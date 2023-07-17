import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[15][15]; 
		
		for (int j = 0; j < 15; j++) {
			arr[j][1] = 1;
			arr[0][j] = j;
		}
		
		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j];
			}
		}
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int K = sc.nextInt(); // 층
			int N = sc.nextInt(); // 호
			
			System.out.println(arr[K][N]);
		}
	}

}
