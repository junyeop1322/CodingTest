import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+2];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
 		}
		
		Stack<Integer> stk = new Stack<>();
		stk.push(0);
		
		int ans = 0;
		
		for (int i = 1; i < n+2; i++) {
			while(!stk.isEmpty()) {
				int num = stk.peek();
				
				if (arr[num] <= arr[i]) {
					break;
				}
				
				stk.pop();
				ans = Math.max(ans, arr[num] * (i - stk.peek() - 1));
			}
			
			stk.push(i);
		}
		
		System.out.println(ans);
	}

}
