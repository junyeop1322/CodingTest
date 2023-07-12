import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int N = sc.nextInt();
			
			if(N == 0) {
				break;
			}
			else {
				int cnt = 0;
				String str = Integer.toString(N);
				
				for (int i = 0; i < str.length() / 2; i++) {
					if(str.charAt(i) == str.charAt(str.length() - 1 - i)) {
						cnt++;
					}
				}
				if (cnt == str.length() / 2) {
					System.out.println("yes");
				}
				else {
					System.out.println("no");
				}
			}
		}
	}
}