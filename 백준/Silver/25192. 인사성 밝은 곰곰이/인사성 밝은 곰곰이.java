import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		
		int cnt = 0;
		
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			if (str.equals("ENTER")) {
				ans += cnt;
				
				cnt = 0;
				map = new HashMap<>();
				
				continue;
			}
			
			if (map.containsKey(str)) {
				continue;
			} else {
				map.put(str, 1);
				cnt++;
			}
		}
		
		ans += cnt;

		System.out.println(ans);
	}

}
