import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = null;
		
		while(!(str = br.readLine()).equals(".")) {
			sb.append(kmp(str + str, str)).append("\n");
		}

		System.out.println(sb.toString());
	}
	
	static int kmp(String parent, String pattern) {
		int cnt = 0;
		int idx = 0;
		
		int len1 = parent.length();
		int len2 = pattern.length();
		
		int[] arr = new int[len2];
		int idx2 = 0;
		for (int i = 1; i < len2; i++) {
			while(idx2 > 0 && pattern.charAt(i) != pattern.charAt(idx2)) {
				idx2 = arr[idx2-1];
			}
			
			if (pattern.charAt(i) == pattern.charAt(idx2)) {
				arr[i] = ++idx2;
			}
		}
		
		for (int i = 0; i < len1-1; i++) {
			while(idx > 0 && parent.charAt(i) != parent.charAt(idx)) {
				idx = arr[idx-1];
			}
			
			if (parent.charAt(i) == parent.charAt(idx)) {
				if (idx == len2-1) {
					cnt++;
					idx = arr[idx];
				} else {
					idx += 1;
				}
			}
		}
		
		return cnt;
	}

}
