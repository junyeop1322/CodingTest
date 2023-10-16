import java.io.*;
import java.util.*;

public class Main {

public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		int[] ans = new int[n];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
 
 
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && ans[stack.peek()] < ans[i]) {
				ans[stack.pop()] = ans[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(ans[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}
