import java.io.*;
import java.util.*;

public class Main {

	static int[] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		memo = new int[n+1];
		Arrays.fill(memo, Integer.MIN_VALUE);
		
		
		int len = 0;
		int idx = 0;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] > memo[len]) {
				len++;
				memo[len] = arr[i];
			} else {
				idx = binarySearch(0, len, arr[i]);
				memo[idx] = arr[i];
			}
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(memo));
		System.out.println(len);
	}
	
	static int binarySearch(int left, int right, int key) {
		int mid = 0;
		
		while(left < right) {
			mid = (left+right)/2;
			
			if (memo[mid] < key) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		
		return right;
	}

}
