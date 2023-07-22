import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		int aH = -1;
		int aM = -1;
		
		if (M < 45) {
			if (H == 0) {
				aH = 23;
			}
			else {
				aH = H -1;
			}
			aM = 60 - (45 - M);
		}
		else {
			aH = H;
			aM = M - 45;
		}
		System.out.printf("%d %d\n", aH, aM);
	}

}
