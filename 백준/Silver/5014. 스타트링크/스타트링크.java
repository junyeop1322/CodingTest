import java.io.*;
import java.util.*;

public class Main {

	static int f, g, u, d;
	static int visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken()); // 배열 전체 크기
		int s = Integer.parseInt(st.nextToken()); // 시작 지점
		g = Integer.parseInt(st.nextToken()); // 목표 지점
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		
		visit = new int[f+1];

		bfs(s);
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = 1;
		q.add(start);
		
		while(!q.isEmpty()) {
			int s = q.poll();
			
			if (s == g) {
				System.out.println(visit[g]-1);
				return;
			}
			
			if (s+u <= f && visit[s+u] == 0) {
				visit[s+u] = visit[s] + 1;
				q.add(s+u);
			}
			if (s-d > 0 && visit[s-d] == 0) {
				visit[s-d] = visit[s] + 1; {
					q.add(s-d);
				}
			}
		}
		
		System.out.println("use the stairs");
	}
}
