import java.util.*;

public class Main {
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int num = sc.nextInt();
			sb.append(upperBound(arr, num) - lowerBound(arr, num)).append(" ");
		}
		
		System.out.println(sb);
		sc.close();
	}

	private static int lowerBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
 
		while (lo < hi) {
 
			int mid = (lo + hi) / 2;
			if (key <= arr[mid]) {
				hi = mid;
			}
 
			else {
				lo = mid + 1;
			}
 
		}
 
		return lo;
	}
 
	private static int upperBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length; 
 
		while (lo < hi) {
 
			int mid = (lo + hi) / 2;
 
			if (key < arr[mid]) {
				hi = mid;
			}

			else {
				lo = mid + 1;
			}
 
		}
 
		return lo;
	}
	
}
