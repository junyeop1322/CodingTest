import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if (n % 7 == 0 || n % 7 == 2) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}

	}

}
