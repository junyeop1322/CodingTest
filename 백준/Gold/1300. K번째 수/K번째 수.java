import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		long lo = 1;
		long hi = k;
		
		while(lo < hi) {
			long mid = (lo + hi) / 2;
			long cnt = 0;
			
			for (int i = 1; i <= n; i++) {
				cnt += Math.min(mid / i, n);
			}
			
			if (cnt < k) {
				lo = mid+1;
			} else {
				hi = mid;
			}
			
		}
		
		System.out.println(lo);
	}

}
