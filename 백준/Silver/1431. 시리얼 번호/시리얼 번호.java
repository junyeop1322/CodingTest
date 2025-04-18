import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1.length() != o2.length())  {
				return o1.length() - o2.length();
			}
			
			int sum1 = 0;
			int sum2 = 0;
			
			for (int i = 0; i < o1.length(); i++) {
				if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {
					sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
				}
			}
			for (int i = 0; i < o2.length(); i++) {
				if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
					sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
				}
			}
			
			if (sum1 == sum2) {
				return o1.compareTo(o2);
			} else {
				return sum1 - sum2;
			}
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

}
