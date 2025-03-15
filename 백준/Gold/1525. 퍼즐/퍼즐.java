import java.io.*;
import java.util.*;


public class Main {
	
	static String ans = "123456780";
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = "";
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				int num = Integer.parseInt(st.nextToken());
				str += num;
			}
		} 
		
		map.put(str, 0);

		System.out.println(bfs(str));
	}

	static int bfs(String str) {
		Queue<String> q = new LinkedList<>();
		q.add(str);
		
		while(!q.isEmpty()) {
			String cur = q.poll();
			
			int cnt = map.get(cur);
			int empty = cur.indexOf('0');
			
			int sx = empty % 3;
			int sy = empty / 3;
			
			if (cur.equals(ans)) {
				return cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx < 0 || ny < 0 || nx > 2 || ny > 2) {
					continue;
				}
				
				int n = ny * 3 + nx;
				char ch = cur.charAt(n);
				
				String next = cur.replace(ch, 'c');
				next = next.replace('0', ch);
				next = next.replace('c', '0');
				
				if (!map.containsKey(next)) {
					q.add(next);
					map.put(next, cnt+1);
				}
			}
		}
		
		return -1;
	}
}
