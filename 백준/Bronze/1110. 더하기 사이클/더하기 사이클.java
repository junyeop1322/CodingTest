import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		int copyN = N;
		
//		if(N < 10) {
//			ans = 1;
//		}
//		else {
			while(true) {
				int a = N / 10;
				int b = N % 10;
				int c = (a + b) % 10;
				
				N = (b * 10) + c;
				ans++;
				
				if (copyN == N) {
					break;
				}
			}
//		}
		
		System.out.print(ans);	
	}
}
