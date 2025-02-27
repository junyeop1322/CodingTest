import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			
			Stack<Character> stk1 = new Stack<>();
			Stack<Character> stk2 = new Stack<>();
			
			int tmp = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if (ch == '<') {
					if (!stk1.isEmpty()) {
						stk2.push(stk1.pop());
					}
				} else if (ch == '>') {
					if (!stk2.isEmpty()) {
						stk1.push(stk2.pop());
					}
				} else if (ch =='-') {
					if (!stk1.isEmpty()) {
						stk1.pop();
					}
				} else {
					stk1.push(ch);
				}
			}
			
			while(!stk2.isEmpty()) {
				stk1.push(stk2.pop());
			}
			
			for (int i = 0; i < stk1.size(); i++) {
				sb.append(stk1.get(i));
			}
			
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}
