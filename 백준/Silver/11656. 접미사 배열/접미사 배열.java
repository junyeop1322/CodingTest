import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < str.length(); i++) {
			list.add(str.substring(i, str.length()));
		}

		Collections.sort(list);
		
		for (String s : list) {
			System.out.println(s);
		}
	}

}
