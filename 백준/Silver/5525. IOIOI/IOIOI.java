import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String str= br.readLine();
		
		int ans = 0, cnt = 0;
		
		
		for (int i = 1; i < m -1; ) {
			if (str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
				cnt++;
				if (cnt == n) {
					if (str.charAt(i- (n*2-1)) == 'I') {
						ans++;
					}
					cnt--;
				}
				
				i += 2;
			} else {
				cnt = 0;
				i++;
			}
		}

		System.out.println(ans);
	}
	
}
