import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String state = st.nextToken();
			
			if (map.containsKey(name)) {
				map.remove(name);
			} else {
				if (state.equals("enter")) {
					map.put(name, 1);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (o1, o2) -> {
			return o2.compareTo(o1);
		});
		
		for (String str : list) {
			sb.append(str).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
