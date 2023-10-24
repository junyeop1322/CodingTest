import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long ans = 0;
		
		Stack<Integer> sta = new Stack<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			while(!sta.isEmpty() && sta.peek() <= num) {
				sta.pop();
			}
			
			sta.push(num);
			
			ans += sta.size() - 1;
		}
		
		System.out.println(ans);
	}

}
