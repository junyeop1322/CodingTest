import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());

		if (n % 5 == 0 || n % 5 == 2) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}

}
