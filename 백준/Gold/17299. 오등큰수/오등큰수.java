import java.io.*;
import java.util.*;

public class Main {

	static int n;
	
	static int[] arr, brr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		brr = new int[1000001];
		int[] ans = new int[n];
		
		Stack<Integer> stk = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			brr[arr[i]]++;
		}
		
		for (int i = 0; i < n; i++) {
			while(!stk.isEmpty() && brr[arr[i]] > brr[arr[stk.peek()]]) {
				ans[stk.pop()] = arr[i];
			}
			
			stk.push(i);
		}
		
		while(!stk.isEmpty()) {
			ans[stk.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(ans[i] + " ");
		}
		
		System.out.println(sb.toString());
	}

}
