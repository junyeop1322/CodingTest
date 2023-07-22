import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int [3];
		int ans = 0;
		
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		if (arr[0] == arr[1]) {
			if (arr[1] == arr[2]) {
				ans = 10000 + (arr[0] * 1000);
			}
			else {
				ans = 1000 + (arr[0] * 100);
			}
		}
		else if (arr[1] == arr[2]) {
			ans = 1000 + (arr[1] * 100);
		}
		else {
			ans = arr[2] * 100;
		}
		
		
		System.out.println(ans);
	}

}
