import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long cnt = 0;
		long[] sum = new long[n+1];
		long[] brr = new long[m];
		
		for (int i = 1; i <= n; i++) {
			sum[i] = arr[i-1] + sum[i-1];
			int num = (int)(sum[i]% m);
			
			if (num == 0) {
				cnt++;
			}
			brr[num]++;
		}
		
		for (int i = 0; i < m; i++) {
			if (brr[i] >= 2) {
				cnt += (brr[i] * (brr[i] -1) / 2);
			}
		}
		
		System.out.println(cnt);

	}

}
