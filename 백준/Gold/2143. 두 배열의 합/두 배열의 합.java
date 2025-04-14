import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long t = Long.parseLong(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] brr = new int[m];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < n; i++) {
			arr[i] += arr[i-1];
		}
		
		for (int i = 1; i < m; i++) {
			brr[i] += brr[i-1];
		}
		
		int cntA = n * (n+1) / 2;
		int cntB = m * (m+1) / 2;
		
		long[] Arr = new long[cntA];
		long[] Brr = new long[cntB];
		
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int a = arr[j];
				
				if (i > 0) {
					a -= arr[i-1];
				}
				
				Arr[idx++] = a;
			}
		}
		
		idx = 0;
		for (int i = 0; i < m; i++) {
			for (int j = i; j < m; j++) {
				int b = brr[j];
				
				if (i > 0) {
					b -= brr[i-1];
				}
				
				Brr[idx++] = b;
			}
		}
		
		Arrays.sort(Arr);
		Arrays.sort(Brr);
		
		int left = 0;
		int right = cntB-1;
		long ans = 0;
		
		while(left < cntA && right > -1) {
			long a = Arr[left];
			long b = Brr[right];
			
			long sum = a + b;
			
			if (sum == t) {
				long ac = 0;
				long bc = 0;
				
				while(left < cntA && a == Arr[left]) {
					left++;
					ac++;
				}
				
				while(right > -1 && b == Brr[right]) {
					right--;
					bc++;
				}
				
				ans += ac * bc;
			}
			
			if (sum > t) {
				right--;
			} else if (sum < t) {
				left++;
			}
		}
		
		System.out.println(ans);
	}

}
