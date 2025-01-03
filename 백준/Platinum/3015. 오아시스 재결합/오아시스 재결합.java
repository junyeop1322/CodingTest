import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		long ans = 0;
		Stack<int[]> stk = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			while(!stk.isEmpty() && stk.peek()[0] < arr[i]) {
				ans += stk.pop()[1];
			}
			
			if (stk.isEmpty()) {
				stk.push(new int[] {arr[i], 1});
			} else {
				if (stk.peek()[0] > arr[i]) {
					stk.push(new int[] {arr[i], 1});
					ans++;
				} else {
					ans += stk.peek()[1]++;
					if (stk.size() > 1) {
						ans++;
					}
				}
			}
		}
		
		System.out.println(ans);
	}

}
