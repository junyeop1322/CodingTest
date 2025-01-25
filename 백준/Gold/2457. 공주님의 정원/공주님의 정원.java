import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		int start;
		int end;
		
		public Node (int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		List<Node> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new Node(a*100 + b, c*100 + d));
		}

		Collections.sort(list, (o1, o2) -> {
			if (o1.start == o2.start) {
				return o1.end - o2.end;
			}
			
			return o1.start - o2.start;
		});
		
		int ans = 0;
		int max = 0;
		
		int idx = 0;
		
		int start = 301;
		
		while(start < 1201) {
			boolean chk = false;
			
			for (int i = idx; i < n; i++) {
				if (list.get(i).start > start) {
					break;
				}
				
				if (list.get(i).start <= start && max < list.get(i).end) {
					max = list.get(i).end;
					idx = i+1;
					chk = true;
				}
			}
			
			if (chk) {
				start = max;
				ans++;
			} else {
				break;
			}
		}
		
		if (max < 1201) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}
		
	}

}
