import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr = new int[9];
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if (arr[i] == max) {
				System.out.println(max);
				System.out.println(i+1);
			}
		}
	}

}
