import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			int cnt = 0;
			boolean check = true;
			boolean[] chk = new boolean[26];
			
			for (int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i);
				
				if (idx != cnt) {
					if (!chk[idx - 'a']) {
						chk[idx - 'a'] = true;
						cnt = idx;
					} else {
						check = false;
						break;
					}
				}
			}
			
			if (check) {
				ans++;
			}
		}

		System.out.println(ans);
	}

}
