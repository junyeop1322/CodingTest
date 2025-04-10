import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int[] alp = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'A';
			alp[idx]++;
		}
		
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if (alp[i] % 2 != 0) {
				cnt++;
			}
		}
		
		String ans = "";
		
		if (cnt > 1) {
			ans += "I'm Sorry Hansoo";
		} else {
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < alp[i] / 2; j++) {
					sb.append((char)(i + 65));
				}
			}
			
			ans += sb.toString();
			String end = sb.reverse().toString();
			
			sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				if (alp[i] % 2 == 1) {
					sb.append((char)(i + 65));
				}
			}
			
			ans += sb.toString() + end;
		}

		System.out.println(ans);
	}

}
