import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		long ans = 0;
		HashMap<Long, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(br.readLine());
			
			map.put(num, map.getOrDefault(num, 0)+1);
			
			if (map.get(num) > max) {
				max = map.get(num);
				ans = num;
			} else if (map.get(num) == max) {
				ans = Math.min(ans, num);
			}
			
		}
		
		System.out.println(ans);
	}

}
