import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arrN = new int [N + 1];
		for (int i = 1; i < arrN.length; i++) {
			arrN[i] = arrN[i -1] + sc.nextInt();
		}
		
		for (int t = 0; t < M; t++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			System.out.println(arrN[end] - arrN[start -1]);
		}
		
//		System.out.println(Arrays.toString(arrN));

		sc.close();
	}

}
