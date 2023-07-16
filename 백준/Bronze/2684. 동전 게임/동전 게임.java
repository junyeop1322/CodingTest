import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int ttt = 0;
			int tth = 0;
			int tht = 0;
			int thh = 0;
			int htt = 0;
			int hth = 0;
			int hht = 0;
			int hhh = 0;
			
			String str = sc.next();
			char[] arr = new char[str.length()];
			
			for (int i = 0; i < 40; i++) {
				arr[i] = str.charAt(i);
			}
			
			for (int i = 1; i < 39; i++) {
				if (arr[i - 1] == 'T') {
					if (arr[i] == 'T') {
						if (arr[i + 1] == 'T') {
							ttt += 1;
						}
						else {
							tth += 1;
						}
					}
					else {
						if (arr[i + 1] == 'T') {
							tht += 1;
						}
						else {
							thh += 1;
						}
					}
				}
				else {
					if (arr[i] == 'T') {
						if (arr[i + 1] == 'T') {
							htt += 1;
						}
						else {
							hth += 1;
						}
					}
					else {
						if (arr[i + 1] == 'T') {
							hht += 1;
						}
						else {
							hhh += 1;
						}
					}
				}
			}
			System.out.printf("%d %d %d %d %d %d %d %d\n", ttt, tth, tht, thh, htt, hth, hht, hhh);
		}
		sc.close();
	}

}
