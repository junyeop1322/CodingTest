import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			Stack<Character> stk = new Stack<>();
			
			for (int j = 0; j < str.length(); j++) {
				if (stk.size() > 0 && stk.peek() == str.charAt(j)) {
					stk.pop();
				} else {
					stk.push(str.charAt(j));
				}
			}
			
			if (stk.size() == 0) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
