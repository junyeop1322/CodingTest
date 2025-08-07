import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int ans = 0;
		int plus = 1;
		int num = 10;
		int N = Integer.parseInt(br.readLine());
		
        for(int i = 1; i <= N; i++) {
			if(i % num == 0) {
				plus ++;
				num *= 10;
			}
			ans += plus;
		}
        
		System.out.println(ans);
	}

}