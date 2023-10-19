import java.io.*;
import java.util.*;

public class Main {

	static long p, q;
	static Map<Long, Long> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());
		
		System.out.println(ans(n));
		
	}
	
	static long ans(long n) {
		if (n == 0) {
			return 1;
		} 
		
		if (map.containsKey(n)) {
			return map.get(n);
		}
		
		map.put(n, ans(n/p) + ans(n/q)); 
		return map.get(n);
	}

}
