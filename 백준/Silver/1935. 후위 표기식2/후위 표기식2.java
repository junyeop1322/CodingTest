import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		Double[] arr = new Double[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}

		Stack<Double> st = new Stack<>();
		
		double num = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (ch >= 'A' && ch <= 'Z') {
				st.push(arr[ch - 65]);
			} else {
				if (!st.isEmpty()) {
					double num2 = st.pop();
					double num1 = st.pop();
					switch(ch) {
						case '+' :
							num = num1 + num2;
							st.push(num);
							continue;
						case '-' :
							num = num1 - num2;
							st.push(num);
							continue;
						case '*' :
							num = num1 * num2;
							st.push(num);
							continue;
						case '/' :
							num = num1 / num2;
							st.push(num);
							continue;
					}
				}
			}
			
		}

		System.out.printf("%.2f", st.pop());
				
	}

}
