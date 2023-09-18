import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			int start = 0;
			int end = n-1;
			while(start < end) {
				 if (arr[start] + arr[end] > arr[i]) {
//					System.out.println("end : " + end);
					end--;
				} else if (arr[start] + arr[end] < arr[i]){
//					System.out.println("start : " + start);
					start++;
				} else {
					if (start == i) {
						start++;
					} else if (end == i) {
						end--;
					} else {
						ans++;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
	}

}
