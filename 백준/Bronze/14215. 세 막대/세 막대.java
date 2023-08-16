import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans = 0;
		int a = arr[0];
		int b = arr[1];
		int c = arr[2];
		
		if (a + b > c) {
			ans = a + b + c;
		} else {
			while(true) {
				if (a + b > c) {
					ans = a + b + c;
					break;
				}
				c--;
			}
		}
		
		System.out.println(ans);
	}

}
