import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append((n+1)/2).append("\n");
			
			ArrayList<Integer> list = new ArrayList<>();
			int cnt = 0;
			
			for (int i = 0; i < n; i++) {
				if (i % 10 == 0) {
					st = new StringTokenizer(br.readLine(), " ");
				}
				
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
				
				Collections.sort(list);
				
				if (i % 2 == 0) {
					if (cnt == 9 || i == n-1) { 
						sb.append(list.get(i/2)).append("\n");
					} else {
						sb.append(list.get(i/2)).append(" ");
					}
					
					cnt++;
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
