import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int n = str.length();
		int ans = 1;
		
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		
		for (int i = 0; i < n / 2; i++) {
			if (str.charAt(i) != sb.charAt(i)) {
				ans = 0;
			}
		}

		System.out.println(ans);
	}

}
