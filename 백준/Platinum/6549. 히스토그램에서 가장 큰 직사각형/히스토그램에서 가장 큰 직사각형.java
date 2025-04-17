import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		int n;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			
			if (n == 0) {
				break;
			}
			
			arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(func(n)).append("\n");
		}

		System.out.println(sb.toString());
	}
	
	static long func(int n) {
		long area = 0;
		Stack<Integer> stk = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			while(!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
				int num1 = arr[stk.pop()];
				long num2 = stk.isEmpty() ? i : i - 1 - stk.peek();
				
				area = Math.max(area, num1 * num2);
			}
			
			stk.push(i);
		}
		
		while(!stk.isEmpty()) {
			int num1 = arr[stk.pop()];
			long num2 = stk.isEmpty() ? n : n - 1 - stk.peek();
			
			area = Math.max(area, num1 * num2);
			
		}
		
		return area;
	}

}
