import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			
			String str = st.nextToken();
			
			if (!map.containsKey(str)) {
				list.add(str);
			}
			
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		Collections.sort(list);
		
		for (String str : list) {
			sb.append(str).append(" ").append(map.get(str)).append("\n");
		}

		System.out.println(sb.toString());
	}

}
