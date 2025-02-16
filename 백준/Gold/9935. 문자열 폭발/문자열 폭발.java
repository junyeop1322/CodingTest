import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String word = br.readLine();
		
		Stack<Character> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		if (word.length() > str.length()) {
			System.out.println(str);
			return;
		}
		
		for (int i = 0; i < str.length(); i++) {
			stk.add(str.charAt(i));
			
			if (stk.size() >= word.length() && stk.peek() == word.charAt(word.length()-1)) {
				boolean chk = false;
				
				for (int j = 0; j < word.length(); j++) {
					if (stk.get(stk.size()-word.length()+j) != word.charAt(j)) {
						chk = true;
						break;
					}
				}
				
				if (!chk) {
					for (int j = 0; j < word.length(); j++) {
						stk.pop();
					}
				}
			}
		}
		
		for (Character c : stk) {
			sb.append(c);
		}
		
		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb.toString());
		}

	}

}
