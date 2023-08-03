import java.util.*;

public class Main {
	
	static int n;
	static int[] arr;
	static int[] brr;
	static boolean[] isSelec;
	static int sour;
	static int bitter;
	static int min;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		isSelec = new boolean[n];
		min = 10000000;
		arr = new int[n];
		brr = new int[n];
		
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			brr[i] = sc.nextInt();
		}
		
		subset(0);
		
		System.out.println(min);
		
	} 
	
	static void subset(int cnt) {
		sour = 1;
		bitter = 0;
		if (cnt == n) {
			for (int i = 0; i < n; i++) {
				if (isSelec[i]) {
					sour *= arr[i];
					bitter += brr[i];
					
					if (Math.abs(sour - bitter) <= min) {
						min = Math.abs(sour - bitter);
					}
				}
			}
			return;
		}
		
		isSelec[cnt] = true;
		subset(cnt+1);
		isSelec[cnt] = false;
		subset(cnt+1);
	}
}
