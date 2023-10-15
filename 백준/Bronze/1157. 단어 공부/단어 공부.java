import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			if ('a' <= str.charAt(i) && 'z' >= str.charAt(i)) {
				arr[str.charAt(i) - 97]++;
			} else {
				arr[str.charAt(i) - 65]++;
			}
		}
		
		int num = -1;
		char ans = '?';
		
		for (int i = 0; i < 26; i++) {
			if (arr[i] > num) {
				num = arr[i];
				ans = (char) (i+65);
			} else if (arr[i] == num) {
				ans = '?';
			}
		}
		
		System.out.println(ans);
	}

}
