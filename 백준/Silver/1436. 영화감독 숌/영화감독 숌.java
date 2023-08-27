import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for (int i = 666; i < 10000000; i++) {
			String str = String.valueOf(i);
			
			for (int j = 0; j < str.length()-2; j++) {
				if (str.charAt(j) == '6' && str.charAt(j+1) == '6' && str.charAt(j+2) == '6') {
					cnt++;
					break;
				}
			}
			
			if (cnt == n) {
				System.out.println(str);
				break;
			}
		}
		
	}

}
