import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			
			map.put(str, i);
		}
		
		String[] arr = new String[m];
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			arr[entry.getValue()] = entry.getKey();
		}
		
		for (int i = 0; i < m; i++) {
			if (arr[i] != null) {
				sb.append(arr[i]).append("\n");
				n--;
			}
			
			if (n == 0) {
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
