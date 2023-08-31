import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = new String[5];
		
		for (int i = 0; i < 5; i++) {
			str[i] = br.readLine();
		}
		
		int max = Math.max(str[0].length(), Math.max(str[1].length(), Math.max(str[2].length(), Math.max(str[3].length(), str[4].length()))));
		
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (str[j].length() > i) {
					sb.append(str[j].charAt(i));
				}
			}
		}
		
		System.out.println(sb);
		
	}

}
