import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int num = 0;
		int sum = 0;
		int tmp;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tmp = Integer.parseInt(st.nextToken());
			
			sum += tmp;
			if (tmp % 2 == 1) {
				num++;
			}
		}
		
		if (sum % 3 == 0 && num <= sum/3) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		
	}

}
