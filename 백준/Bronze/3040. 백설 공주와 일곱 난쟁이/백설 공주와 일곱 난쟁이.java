import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;
	static int[] res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		res = new int[7];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
	}

	static void comb(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += res[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(res[i]);
				}
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			res[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
	
}
