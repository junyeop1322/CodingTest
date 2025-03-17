import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		Stack<Integer>[] stk = new Stack[7];
		for (int i = 0; i < 7; i++) {
			stk[i] = new Stack<>();
		}
		
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			while(!stk[a].isEmpty() && stk[a].peek() > b) {
				stk[a].pop();
				cnt++;
			}
			
			if (stk[a].empty() || (!stk[a].isEmpty() && stk[a].peek() < b)) {
				stk[a].push(b);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
