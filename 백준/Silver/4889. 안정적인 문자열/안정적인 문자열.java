import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = 1;
		
		while(true) {
			String str = br.readLine();
			int n = str.length();
			int cnt = 0;
			
			if (str.contains("-")) {
				break;
			}
			
			Stack<Character> stk = new Stack<>();
			for (int i = 0; i < n; i++) {
				char ch = str.charAt(i);
				
				if (ch == '{') {
					stk.add(ch);
				} else {
					if (stk.isEmpty()) {
						cnt++;
						stk.add('{');
					} else {
						stk.pop();
					}
				}
			}
			
			int ans = cnt + stk.size() / 2;
			
			sb.append(num + ". " + ans).append("\n");
			num++;
		}

		System.out.println(sb.toString());
	}

}
