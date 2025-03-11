import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k;
	static Set<String> set = new HashSet<>();
	static String[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		arr = new String[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		func(k, "");
		
		
		System.out.println(set.size());
	}
	
	static void func(int idx, String str) {
		if (idx == 0) {
			set.add(str);
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				func(idx-1, str + arr[i]);
				visited[i] = false;
			}
		}
	}

}
