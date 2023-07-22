import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		int C = sc.nextInt();
		int aH = H;
		int aM = M + C;
		
		if (aM >= 60) {
			while(true) {
				if (aH == 23) {
					aH = 0;
					aM -= 60;
				}
				else {
					aH += 1;
					aM -= 60;
				}
				
				if (aM < 60) {
					break;
				}
			}
		}
		
		
		System.out.printf("%d %d\n", aH, aM);
	}

}
