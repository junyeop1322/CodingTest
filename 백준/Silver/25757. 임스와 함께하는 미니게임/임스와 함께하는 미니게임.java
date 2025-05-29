import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() ," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		String str = st.nextToken();
		
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		if (str.equals("Y")) {
			System.out.println(set.size() / 1);
		} else if (str.equals("F")) {
			System.out.println(set.size() / 2);
		} else if (str.equals("O")) {
			System.out.println(set.size() / 3);
		}
	}

}
