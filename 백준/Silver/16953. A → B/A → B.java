import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		int ans = 1;
	
		while (n != m) {
			if (m < n) {
				ans = -1;
				break;
			}
			
			if (m %10 != 1 && m % 2 != 0) {
				ans = -1;
				break;
			}
			
			if (m % 2 == 0) {
				m = m/2;
			} else {
				m = (m-1) / 10;
			}
			
			ans++;
		}
		
		System.out.println(ans);		
		
	}
	

}
