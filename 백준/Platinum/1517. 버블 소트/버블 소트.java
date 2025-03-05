import java.io.*;
import java.util.*;

public class Main {

	static long ans = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		long[] tmp = new long[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		sort(arr, tmp, 0, arr.length-1);
		
		System.out.println(ans);
	}
	
	static void sort(long[] arr, long[] tmp, int left, int right) {
		if (left != right) {
			int mid = (left + right) / 2;
			sort(arr, tmp, left, mid);
			sort(arr, tmp, mid+1, right);
			merge(arr, tmp, left, right);
		}
	}
	
	static void merge(long[] arr, long[] tmp, int left, int right) {
		int m = (left + right) / 2;
		int l = left;
		int r = m+1;
		int i = left;
		
		while(l <= m && r <= right) {
			if (arr[l] > arr[r]) {
				ans += (m-l+1);
				tmp[i++] = arr[r++];
			} else {
				tmp[i++] = arr[l++];
			}
		}
		
		if (l > m) {
			while(r <= right) {
				tmp[i++] = arr[r++];
			}
		}
		
		if (r > l) {
			while(l <= m) {
				tmp[i++] = arr[l++];
			}
		}
		
		for (int j = left; j <= right; j++) {
			arr[j] = tmp[j];
		}
	}

}
