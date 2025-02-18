import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			
			map.put(str, map.getOrDefault(str, 0) + 1);
			max = Math.max(max, map.get(str));
		}

		List<String> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				list.add(entry.getKey());
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(0));
	}

}
