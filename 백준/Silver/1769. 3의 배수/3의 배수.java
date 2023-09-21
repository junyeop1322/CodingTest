import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int cnt = 0;
		
		while(str.length() > 1) {
			int num = 0;
			
			for (int i = 0; i < str.length(); i++) {
				num += str.charAt(i) - '0';
			}
			
			str = Integer.toString(num);	
			cnt++;
		}
		
		int ans = Integer.parseInt(str);
		if (ans % 3 == 0) {
			System.out.println(cnt);
			System.out.println("YES");
		} else {
			System.out.println(cnt);
			System.out.println("NO");
		}
		
	}

}
