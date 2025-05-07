import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[] arr = new int[52];
		int[] brr = new int[52];
		
		for (char ch : str1.toCharArray()) {
			if ('a' <= ch && ch <= 'z') {
				arr[ch-'a'] += 1;
			} else {
				arr[ch-'A'+26] += 1;
			}
		}
		
		int start = 0;
		int cnt = 0;
		int ans = 0;
		
		for (int i = 0; i < str2.length(); i++) {
			char ch = str2.charAt(i);
			if ('a' <= ch && ch <= 'z') {
				brr[ch-'a'] += 1;
			} else {
				brr[ch-'A'+26] += 1;
			}
			
			cnt++;
			
			if (cnt == str1.length()) {
				if (Arrays.equals(arr, brr)) {
					ans++;
				}
				
				if ('a' <= str2.charAt(start) && str2.charAt(start) <= 'z') {
					brr[str2.charAt(start) - 'a'] -= 1;
				} else {
					brr[str2.charAt(start) - 'A' + 26] -= 1;
				}
				
				start++;
				cnt--;
			}
			
		}
		
		System.out.println(ans);
	}

}
