import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] <= K) {
				cnt++;
			}
		}

		int[] brr = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			brr[i] = arr[i];
		}
		
		
		int ans = 0;
		for (int i = cnt-1; i >= 0; i--) {
			ans += (K / brr[i]);
			K = K % brr[i];
		}
		
		
		System.out.println(ans);
	}

}
