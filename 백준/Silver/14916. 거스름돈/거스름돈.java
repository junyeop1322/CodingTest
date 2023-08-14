import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		
		// 11(4) 12(3) 13(5) 14(4) 15(3)
		// 16(5) 17(4) 18(6) 19(5) 20(4)
		
		if (n >= 5) {
			if (n % 5 == 0) {
				ans = n / 5;
			} else if (n % 5 == 1 || n % 5 == 4) {
				ans = (n / 5) + 2;
			} else if (n % 5 == 2) {
				ans = (n / 5) + 1;
			} else if (n % 5 == 3) {
				ans = (n / 5) + 3;
			}
		} else {
			if (n == 1 || n == 3) {
				ans = -1;
			} else if (n == 2 || n == 4) {
				ans = n / 2;
			}
		}
		
		System.out.println(ans);
	}

}
