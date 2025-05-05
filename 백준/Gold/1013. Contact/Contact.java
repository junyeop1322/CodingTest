import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String word = "(100+1+|01)+";

		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			
			if (str.matches(word)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
