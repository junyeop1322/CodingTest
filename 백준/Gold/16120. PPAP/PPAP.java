import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stk = new Stack<>();
		
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			stk.add(ch);
			
			if (stk.size() >= 4) {
				String tmp = "";
				for (int j = 0; j < 4; j++) {
					tmp = stk.pop() + tmp;
				}
				
				if (tmp.equals("PPAP")) {
					stk.add('P');
				} else {
					for (int j = 0; j < 4; j++) {
						stk.add(tmp.charAt(j));
					}
				}
			}
		}
		
		if (stk.size() == 1 && stk.peek() == 'P') {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
		
	}

}
