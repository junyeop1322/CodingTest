import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
		int N = sc.nextInt();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if (arr[a] == 2) {
				arr[a] = b;
			}
			else {
				if (arr[a] == b) {
					arr[a] = b;
				}
				else {
					arr[a] = b;
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
