import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		boolean chk = false;
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (ch == '<') {
				chk = true;
				sb.append(sb2.reverse());
				sb.append(ch);
				
				sb2 = new StringBuilder();
			} else if (ch == '>') {
				chk = false;
				sb.append(sb2).append(ch);
				sb2 = new StringBuilder();
			} else if (ch == ' ') {
				if (chk) {
					sb2.append(ch);
				} else {
					sb.append(sb2.reverse()).append(ch);
					sb2 = new StringBuilder();
				}
			} else {
				sb2.append(ch);
			}
		}

		if (!sb2.equals("")) {
			sb.append(sb2.reverse());
		}
		
		System.out.println(sb);
	}

}
