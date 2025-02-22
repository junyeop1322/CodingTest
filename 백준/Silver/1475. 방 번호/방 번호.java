import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] num = new int[10];
		
		for (int i = 0; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			
			if (n == 6 || n == 9) {
				if (num[6] < num[9]) {
					num[6]++;
				} else if (num[6] > num[9]) {
					num[9]++;
				} else {
					num[n]++;
				}
			} else {
				num[n]++;
			}
		}

		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans = Math.max(ans, num[i]);
		}
		
		System.out.println(ans);
	}

}
