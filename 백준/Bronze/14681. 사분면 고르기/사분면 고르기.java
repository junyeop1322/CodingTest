import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int ans = 0;
		
		if (x > 0) {
			if (y > 0) {
				ans = 1;
			}
			else {
				ans = 4;
			}
		}
		else {
			if (y > 0) {
				ans = 2;
			}
			else {
				ans = 3;
			}
		}
		
		System.out.println(ans);
	}

}
