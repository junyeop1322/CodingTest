import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] arr = new String[N + 1];

        HashMap<Integer, String> map_int = new HashMap<>();
        HashMap<String, Integer> map_str = new HashMap<>();
        
		for (int i = 1; i <= N; i++) {
			arr[i] = br.readLine();
			map_int.put(i, arr[i]);
			map_str.put(arr[i], i);
			
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

//			System.out.println(check(str));
			if (!check(str)) {
				sb.append(map_str.get(str)+"\n");

			} else {
				int num = Integer.parseInt(str);
				sb.append(arr[num]).append("\n");
			}
		}

		
		System.out.println(sb);
	}

	static boolean check(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
