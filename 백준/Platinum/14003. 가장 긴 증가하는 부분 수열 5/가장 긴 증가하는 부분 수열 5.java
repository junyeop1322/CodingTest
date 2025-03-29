import java.io.*;
import java.util.*;

public class Main {
	
	static int[] list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new int[n+1];
		list[0] = -1000000001;
		
		int[] dp = new int[n];
		int len = 0;
		int idx = 0;
		
		for (int i = 0; i < n; i++) {
			if (arr[i] > list[len]) {
				dp[i] = ++len;
				list[len] = arr[i];
			} else {
				idx = binary(0, len, arr[i]);
				list[idx] = arr[i];
				dp[i] = idx;
			}
		}
		
		sb.append(len + "\n");
		
		Stack<Integer> stk = new Stack<>();
		for (int i = n-1; i >= 0; i--) {
			if (dp[i] == len) {
				stk.push(arr[i]);
				len--;
			}
		}
		
		while(!stk.isEmpty()) {
			sb.append(stk.pop() + " ");
		}
		
		System.out.println(sb.toString());
	}
	
	static int binary(int left, int right, int num) {
		int mid = 0;
		
		while(left < right) {
			mid = (left + right) / 2;
			
			if (list[mid] < num) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		
		return right;
	}

}
