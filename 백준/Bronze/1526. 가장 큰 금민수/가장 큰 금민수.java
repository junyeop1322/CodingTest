import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = N; i >= 4; i--) {
			boolean check = true;
			int num = i;
			
			while (num != 0) {
				if (num % 10 == 4 || num % 10 == 7) {
					num /= 10;
				}
				else {
					check = false;
					break;
				}
			}
			
			if (check) {
				System.out.println(i);
				break;
			}
		}
	}

}
