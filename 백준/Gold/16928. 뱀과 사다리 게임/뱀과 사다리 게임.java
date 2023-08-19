import java.util.*;
import java.io.*;

public class Main {

	static int j, s;
	static int[][] jump;
	static int[][] snake;
	static int[] map = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		j = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		jump = new int[j][2];
		snake = new int[s][2];

		for (int i = 0; i < j; i++) {
			st = new StringTokenizer(br.readLine());
			jump[i][0] = Integer.parseInt(st.nextToken());
			jump[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			snake[i][0] = Integer.parseInt(st.nextToken());
			snake[i][1] = Integer.parseInt(st.nextToken());
		}

		bfs(1);

	}

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		map[start] = 1;
		que.offer(start);

		while (true) {
			int x = que.poll();

			if (x == 100) {
				System.out.println(map[x]-1);
				return;
			}

			for (int n = 1; n <= 6; n++) {
				int nx = x + n;

				if (nx <= 100) {
					for (int i = 0; i < j; i++) {
						if (nx == jump[i][0]) {
							nx = jump[i][1];
							if (map[nx] == 0) {
								map[nx] = map[x] + 1;
								que.offer(nx);
							}
						}
					}
					for (int i = 0; i < s; i++) {
						if (nx == snake[i][0]) {
							nx = snake[i][1];
							if (map[nx] == 0) {
								map[nx] = map[x] + 1;
								que.offer(nx);
							}
						}
					}
					if (map[nx] == 0) {
						map[nx] = map[x] + 1;
						que.offer(nx);
					}
				}
			}
		}
	}

}
