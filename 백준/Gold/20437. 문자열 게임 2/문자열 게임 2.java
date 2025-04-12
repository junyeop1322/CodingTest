import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			int k = Integer.parseInt(br.readLine());
			
			if (k == 1) {
				sb.append("1 1").append("\n");
				continue;
			}
			
			int[] alpha = new int[26];
			for (int i = 0; i < str.length(); i++) {
				alpha[str.charAt(i) - 'a']++;
			}
			
			int min = Integer.MAX_VALUE;
			int max = -1;
			
			for (int i = 0; i < str.length(); i++) {
				if (alpha[str.charAt(i) - 'a'] < k) {
					continue;
				}
				
				int cnt = 1;
				
				for (int j = i+1; j < str.length(); j++) {
					if (str.charAt(i) == str.charAt(j)) {
						cnt++;
					}
					
					if (cnt == k) {
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						break;
					}
				}
			}
			
			if (min == Integer.MAX_VALUE || max == -1) {
				sb.append("-1").append("\n");
				continue;
			}
			
			sb.append(min + " " + max).append("\n");
		}

		System.out.println(sb.toString());
	}

}
