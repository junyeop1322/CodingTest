import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder s = new StringBuilder(br.readLine());
		StringBuilder t = new StringBuilder(br.readLine());
		
		int ans = 0;
		
		while(s.length() < t.length()) {
			if (t.charAt(t.length()-1) == 'A') {
				t.delete(t.length()-1, t.length());
			} else {
				t.delete(t.length()-1, t.length());
				t.reverse();
			}
			
			if (t.length() == s.length()) {
				if (t.toString().equals(s.toString())) {
					ans = 1;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}
