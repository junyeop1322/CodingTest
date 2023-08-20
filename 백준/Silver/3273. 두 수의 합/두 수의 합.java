import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int x = Integer.parseInt(br.readLine());
		int cnt = 0;
		int s = 0;
		int e = n-1;
		
		while (s < e) {
			if (arr[s] + arr[e] == x) {
				cnt++;
				s++;
				e--;
			} else if (arr[s] + arr[e] < x) {
				s++;
			} else if (arr[s] + arr[e] > x) {
				e--;
			}
		}
		
		System.out.println(cnt);
		
	}

}
