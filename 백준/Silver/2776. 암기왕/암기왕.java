import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			Set<Integer> hash = new HashSet<>();
			
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				hash.add(Integer.parseInt(st.nextToken()));
			}
			
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				sb.append(hash.contains(Integer.parseInt(st.nextToken()))? 1 : 0).append("\n");
			}
			
		}
		
		System.out.println(sb);
	}

}
