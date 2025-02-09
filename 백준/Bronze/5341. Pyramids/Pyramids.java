import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				break;
			}
			
			sb.append(num*(num+1)/2 + "\n");
		}

		System.out.println(sb.toString());
	}

}
