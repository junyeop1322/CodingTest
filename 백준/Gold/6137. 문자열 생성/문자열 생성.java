import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Character> list = new ArrayList<>();
		
		char[] alpha = new char[n];
		for (int i = 0; i < n; i++) {
			alpha[i] = br.readLine().charAt(0);
		}
		
		int start = 0;
		int end = n-1;
		
		while(start <= end) {
			if ((int)alpha[start] < (int)alpha[end]) {
				list.add(alpha[start++]);
			} else if ((int)alpha[start] == (int)alpha[end]) {
				int s =  start;
				int e = end;
				boolean chk = false;
				
				while(alpha[s] == alpha[e]) {
					if (e > 0) {
						e--;
					}
					if (s < n-1) {
						s++;
					}
					
					if ((int)alpha[s] < (int)alpha[e]) {
						chk = true;
					} else if ((int)alpha[s] > (int)alpha[e]) {
						chk = false;
					}
				}
				
				if (chk) {
					list.add(alpha[start++]);
				} else {
					list.add(alpha[end--]);
				}
				
			} else {
				list.add(alpha[end--]);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (i != 0 && i % 80 == 0) {
				sb.append("\n");
			}
			
			sb.append(list.get(i));
		}

		System.out.println(sb.toString());
	}

}
