import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int ans = 0;
		if (N % 4 == 0) {
			if(N % 100 == 0) {
				if (N % 400 == 0) {
					ans = 1;
				}
				else {
					ans = 0;
				}
			}
			else {
				ans = 1;
			}
		}
		
		System.out.println(ans);
		
	}
}
