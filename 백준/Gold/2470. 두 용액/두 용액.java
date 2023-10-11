import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = n-1;
		int min = Integer.MAX_VALUE;
		
		int a = 0;
		int b = 0;
		
		while(start < end) {
			
			if (Math.abs(arr[start] + arr[end]) < min) {
				min = Math.abs(arr[start] + arr[end]);
				a = arr[start];
				b = arr[end];
			} else {
				if (Math.abs(arr[start+1] + arr[end]) > Math.abs(arr[start] + arr[end-1])) {
					end--;
				} else {
					start++;
				}
			}
		}
		
		System.out.println(a + " " + b);
	}

}
