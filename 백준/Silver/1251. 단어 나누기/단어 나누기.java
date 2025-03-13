import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		List<String> list = new ArrayList<>();
		
		for (int i = 1; i < str.length()-1; i++) {
			for (int j = i+1; j < str.length(); j++) {
				String s = "";
				
				s += back(str.substring(0, i));
				s += back(str.substring(i, j));
				s += back(str.substring(j));
				
				list.add(s);
			}
		}
		
		Collections.sort(list);

		System.out.println(list.get(0));
	}
	
	public static String back(String str) {
		StringBuilder sb = new StringBuilder(str);
		
		return sb.reverse().toString();
	}

}
