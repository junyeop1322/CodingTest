import java.io.*;

public class Main {
	
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int s = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int ans = 0;
		
		for (int i = 0; i <= s - (n*2 + 1); i++) {
			if (str.charAt(i) == 'I') {
				if (check(i, str)) {
					ans++;
				}
			}
		}

		System.out.println(ans);
	}
	
	static boolean check(int idx, String str) {
		boolean chk = true;
		
		int cnt = 1;
		for (int i = idx+1; i < idx + (n*2+1); i++) {
			if (cnt % 2 == 1) {
				if (str.charAt(i) != 'O') {
					chk = false;
					break;
				}
			} else {
				if (str.charAt(i) != 'I') {
					chk = false;
					break;
				}
			}
			
			cnt++;
		}
		
		return chk;
	}

}
