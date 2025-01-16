import java.io.*;

public class Main {

	static long n;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Long.parseLong(br.readLine());
		long num = n;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				num = num / i * (i-1);
				while(n % i == 0) {
					n = n / i;
				}
			}
		}
		
		if (n != 1) {
			num = num / n * (n - 1);
		}
		
		System.out.println(num);
	}

}
