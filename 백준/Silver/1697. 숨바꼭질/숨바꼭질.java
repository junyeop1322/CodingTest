import java.util.*;
import java.io.*;

public class Main {

	static int k;
	static int ans = 0;
	static int[] visit = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (n == k) {
			System.out.println(0);
		} else {
			bfs(n);
		}

	}
	// 3 + 9 + 27

	static void bfs(int n) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(n);
		visit[n] = 1;

		while (true) {
			int num = que.poll();

			for (int i = 0; i < 3; i++) {
				int next = 0;

				if (i == 0) {
					next = num - 1;
				} else if (i == 1) {
					next = num + 1;
				} else {
					next = num * 2;
				}

				if (next == k) {
					System.out.println(visit[num]);
					return;
				}

				if (next >= 0 && next < visit.length && visit[next] == 0) {
					que.offer(next);
					visit[next] = visit[num] + 1;
				}
			}
		}
	}

}
