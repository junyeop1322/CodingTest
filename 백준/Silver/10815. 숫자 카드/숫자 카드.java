import java.util.*;
import java.io.*;

public class Main {
	
	static int[] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int check = Integer.parseInt(st.nextToken());
			if (find(check)) {
				bw.write("1 ");
			} else {
				bw.write("0 ");
			}
		}
		
		br.close();
		bw.close();
	}
	
	static boolean find(int num) {
		int s = 0;
		int e = n-1;
		
		while(s <= e) {
			int midIndex = ((s + e) / 2);
			int mid = arr[midIndex];
			
			if (mid > num) {
				e = midIndex-1;
			} else if (mid < num) {
				s = midIndex+1;
			} else {
				return true;
			}
		}
		return false;
	}

}