import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		int sum = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (ans+1 < arr[i]) {
				break;
			}
			ans += arr[i];
		}
		
		ans++;
		
		System.out.println(ans);
	}

}
