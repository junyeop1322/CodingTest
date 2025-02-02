import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			long n = Long.parseLong(br.readLine());
			
			sb.append(func(n) + "\n");
		}

		System.out.println(sb.toString());
	}
	
	static int func(long n) {
		int cnt = 0;
		
		long num = 2 * n;
		
		for (long i = 2; i*i <= num; i++) {
			if (num % i == 0) {
				long m = num / i;
				
				if ((m - i + 1) % 2 == 0) {
					long a = (m - i + 1) / 2;
					if (a >= 1) {
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	}

}
