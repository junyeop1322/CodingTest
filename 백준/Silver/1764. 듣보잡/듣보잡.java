import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> arr = new HashSet<>();
		List<String> brr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			arr.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			
			if (arr.contains(str)) {
				brr.add(str);
			}
		}
		
		Collections.sort(brr);
		System.out.println(brr.size());
		for (int i = 0; i < brr.size(); i++) {
			System.out.println(brr.get(i));
		}
	}
}