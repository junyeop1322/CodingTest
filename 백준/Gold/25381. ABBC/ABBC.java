import java.io.*;
import java.util.*;

public class Main {
	
	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		ans = 0;
		
		Queue<Integer> qA = new LinkedList<>();
		Queue<Integer> qB = new LinkedList<>();
		Queue<Integer> qC = new LinkedList<>();
		
		for (int i = str.length()-1; i >= 0; i--) {
			char ch = str.charAt(i);
			
			if (ch == 'A') {
				qA.add(i);
			} else if (ch == 'B') {
				qB.add(i);
			} else {
				qC.add(i);
			}
		}
		
		while(!qA.isEmpty()) {
			if (qB.isEmpty()) {
				break;
			}
			
			if (qA.peek() < qB.peek()) {
				ans++;
				qA.poll();
				qB.poll();
			} else {
				qA.poll();
			}
		}
		
		while(!qB.isEmpty()) {
			if (qC.isEmpty()) {
				break;
			}
			
			if (qB.peek() < qC.peek()) {
				ans++;
				qB.poll();
				qC.poll();
			} else {
				qB.poll();
			}
		}
		
		System.out.println(ans);
	}
	
}
