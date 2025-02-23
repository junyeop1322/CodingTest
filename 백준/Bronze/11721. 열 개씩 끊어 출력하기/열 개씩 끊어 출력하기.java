import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			
			if (i % 10 == 9) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
