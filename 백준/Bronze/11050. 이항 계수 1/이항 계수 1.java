import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		int nn = 1;
		int nr = 1;
		
		for (int i = n-r+1; i <= n; i++) {
			nn *= i;
		}
		
		for (int i = 1; i <= r; i++) {
			nr *= i;
		}
		
		int ans = nn / nr;
		
		System.out.println(ans);
	}

}
