import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a = 1;
		int b = 3;
		
		for (int i = 1; i < n; i++) {
			a *= 2;
			b = b + a;
		}
		
		int ans = b * b;
		System.out.println(ans);
		
		sc.close();
	}
}

// 3 5 9 17 33
//  2 4 8 16 