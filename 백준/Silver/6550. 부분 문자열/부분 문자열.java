import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str;
		
		while(true) {
			str = br.readLine();
			
			if (str == null) {
				break;
			}
			
			st = new StringTokenizer(str, " ");
			String s = st.nextToken();
			String t = st.nextToken();
			
			int idx = 0;
			
			for (int i = 0; i < t.length(); i++) {
				if (t.charAt(i) == s.charAt(idx)) {
					idx++;
				}
				
				if (idx == s.length()) {
					break;
				}
			}
			
			if (idx == s.length()) {
				sb.append("Yes").append("\n");
			} else {
				sb.append("No").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
