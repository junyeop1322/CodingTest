import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		cnt = (V - B) / (A - B);
		
		
		
		if ((V - B) % (A - B) != 0) {
			cnt++;
		}
		
		
//		while(true) {
//			sum += A;
//			if(sum >= V) {
//				break;
//			}
//			
//			sum -= B;
//			cnt++;
//		}
		
		System.out.println(cnt);
	}

}
