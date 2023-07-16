import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int king = sc.nextInt();
		int queen = sc.nextInt();
		int look = sc.nextInt();
		int beshop = sc.nextInt();
		int knight = sc.nextInt();
		int phon = sc.nextInt();
		
		int ki = 1 - king;
		int qu = 1 - queen;
		int lo = 2 - look;
		int be = 2 - beshop;
		int kn = 2 - knight;
		int ph = 8 - phon;
		
		System.out.printf("%d %d %d %d %d %d\n", ki, qu, lo, be, kn, ph);
		sc.close();
	}

}
