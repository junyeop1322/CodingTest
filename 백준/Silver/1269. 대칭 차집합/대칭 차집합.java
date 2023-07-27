import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		Set<Integer> arr = new HashSet<>();
		Set<Integer> brr = new HashSet<>();
		
		int ans = 0;
		for (int i = 0; i < a; i++) {
			arr.add(sc.nextInt());
		}
		for (int i = 0; i < b; i++) {
			brr.add(sc.nextInt());
		}
		
		for (int num : arr) {
			if(!(brr.contains(num))) {
				ans += 1;
			}
		}
		for (int num : brr) {
			if(!(arr.contains(num))) {
				ans += 1;
			}
		}
		
		System.out.println(ans);
		
	}

}
