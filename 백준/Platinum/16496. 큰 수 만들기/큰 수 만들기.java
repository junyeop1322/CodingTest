import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			str[i] = st.nextToken();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
			
		});
		
		if (str[0].equals("0")) {
			System.out.println(0);
			return;
		}
		
		System.out.println(String.join("", str));
	}

}
