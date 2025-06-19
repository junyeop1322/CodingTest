import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			stack.push(Integer.parseInt(br.readLine()));
			if(max < stack.peek()) max = stack.peek();
		}
		
		int s = 0;
		int result = 0;

		for (int i = 0; i < n; i++) {
			int p = stack.pop();
			if(s < p) {
				s = p;
				result++;
			}
			if (p == max) break;
		}
		
		System.out.println(result);
	}

}