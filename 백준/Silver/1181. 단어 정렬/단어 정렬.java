import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> ans = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, (o1, o2) -> {
			if (o1.length() == o2.length()) {
				for (int i = 0; i < o1.length(); i++) {
					if (o1.charAt(i) != o2.charAt(i)) {
						return o1.charAt(i) - o2.charAt(i);
					}
				}
			}
			return o1.length() - o2.length();
		});
		
		
		for (int i = 0; i < N; i++) {
			if (!ans.contains(str[i])) {
				ans.add(str[i]);
			}
		}
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
		
	}
}
