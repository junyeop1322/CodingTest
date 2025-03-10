import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (map.containsKey(num)) {				
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
		}

		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		int cnt = 0;
		
		for (int num : list) {
			if (map.get(num) == 1) {
				cnt++;
				sb.append(num + " ");
			}
		}
		
		if (cnt == 0) {
			System.out.println(cnt);
		} else {			
			System.out.println(cnt);
			System.out.println(sb);
		}
	}

}
