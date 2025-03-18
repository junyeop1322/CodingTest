import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		set.add("ChongChong");

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			if (set.contains(str1) || set.contains(str2)) {
				set.add(str1);
				set.add(str2);
			}
		}
		
		System.out.println(set.size());
	}

}
