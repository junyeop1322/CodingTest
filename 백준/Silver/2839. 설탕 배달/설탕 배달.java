import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = -1;
		// 11 (3) 12 (4) 13 (3) 14 (4)
		// 16 (4) 17 (5) 18 (4) 19 (5)

		if (N >= 5 && N != 7) {
			if (N % 5 == 0) {
				ans = N / 5;
			} else if (N % 5 == 1 || N % 5 == 3) {
				ans = (N / 5) + 1;
			} else if (N % 5 == 2 || N % 5 == 4) {
				ans = (N / 5) + 2;
			}
		} else {
			if (N % 3 == 0) {
				ans = N / 3;
			}
		}
		
		System.out.println(ans);
	}

}
