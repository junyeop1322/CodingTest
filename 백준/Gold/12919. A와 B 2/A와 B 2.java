import java.io.*;

public class Main {
	
	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		ans = 0;
		
		dfs(s, t);
		
		System.out.println(ans);
	}
	
	static void dfs(String s, String t) {
		if (s.length() == t.length()) {
			if (s.equals(t)) {
				ans = 1;
			}
			return;
		}
		
		if (ans == 1) {
			return;
		}
		
		if (t.endsWith("A")) {
			dfs(s, t.substring(0, t.length()-1));
		}
		
		if (t.startsWith("B")) {
			dfs(s, new StringBuilder(t.substring(1)).reverse().toString());
		}
		
	}
}
