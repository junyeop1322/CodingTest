import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		String[] arr;
		
		for (int t = 1; t <= T; t++) {
			sb.append("Case #").append(t).append(": ");
			arr = br.readLine().split(" ");
			
			for (int i = arr.length-1; i >= 0; i--) {
				sb.append(arr[i]).append(" ");
			}
			
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}
