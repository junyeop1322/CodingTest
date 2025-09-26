import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());

		long arr[] = new long[n];
		String str = "", temp = "";

		while (n > 0) {
			while (st.hasMoreTokens()) {
				str = st.nextToken();
				temp = "";
				for (int i = str.length() - 1; i >= 0; i--) {
					temp += str.charAt(i);
				}
				arr[--n] = Long.parseLong(temp);
			}
			if (n > 0)
				st = new StringTokenizer(bf.readLine());
		}
		Arrays.sort(arr);
        
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}