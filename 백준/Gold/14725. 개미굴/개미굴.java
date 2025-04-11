import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		HashMap<String, Node> map;
		
		public Node() {
			map = new HashMap<>();
		}
	}
	
	static int n;
	static Node node = new Node();
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			Node cur = node;
			
			for (int j = 0; j < k; j++) {
				String str = st.nextToken();
				
				if (!cur.map.containsKey(str)) {
					cur.map.put(str, new Node());
				}
				
				cur = cur.map.get(str);
			}
		}
		
		sb = new StringBuilder();
		func(node, "");
		
		System.out.println(sb);
	}
	
	static void func(Node cur, String s) {
		ArrayList<String> list = new ArrayList<>(cur.map.keySet());
		Collections.sort(list);
		
		for (String str : list) {
			sb.append(s).append(str).append("\n");
			func(cur.map.get(str), s + "--");
		}
	}

}
