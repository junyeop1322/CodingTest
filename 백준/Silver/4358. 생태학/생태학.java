import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> map = new HashMap<>();
		int cnt = 0;
		String str;
		
		while((str = br.readLine()) != null) {
			cnt++;
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		List<String> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String s = entry.getKey();
			list.add(s);
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		
		for (String s : list) {
			int count = map.get(s) * 100;
			sb.append(s + " " + String.format("%.4f", (double)count / (double)cnt) + "\n");
		}
		
		System.out.println(sb);
	}

}
