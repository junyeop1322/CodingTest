import java.io.*;
import java.util.*;


public class Main {
	
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			int dist = m - n;
			int max = (int)Math.sqrt(dist);
			
			if (max == Math.sqrt(dist)) {
				sb.append(max * 2 - 1).append("\n");
			} else if (dist <= max* max + max) {
				sb.append(max * 2).append("\n");
			} else {
				sb.append(max * 2 + 1).append("\n");
			}
			
			
		}
		
		System.out.println(sb);
	}

}
