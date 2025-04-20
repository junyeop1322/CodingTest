import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		if (k >= n) {
			System.out.println(0);
			return;
		}
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] brr = new int[n-1];
		for (int i = 0; i < n-1; i++) {
			brr[i] = arr[i+1] - arr[i];
		}
		
		Arrays.sort(brr);
		
		int ans = 0;
		
		for (int i = 0; i < n-k; i++) {
			ans += brr[i];
		}
		
		System.out.println(ans);
	}

}
