import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] sumArr = new int[500002];
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> zeroQ = new LinkedList<>();
		int cnt = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, cnt);
					cnt++;
				} else if (map[i][j] == 0) {
					zeroQ.add(new int[] {i, j});
				}
			}
		}
		
		int ans = 0;
		
		while(!zeroQ.isEmpty()) {
			int[] cur = zeroQ.poll();
			int x = cur[0];
			int y = cur[1];
			
			ans = Math.max(ans, func(x, y));
		}
		
		System.out.println(ans);
	}
	
	static int func(int x, int y) {
		int sol = 1;
		
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
				continue;
			}
			
			int next = map[nx][ny];
			
			if (next > 1 && !set.contains(next)) {
				sol += sumArr[next];
				set.add(next);
			}
		}
		
		return sol;
	}
	
	static void bfs(int x, int y, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		int sum = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int sx = cur[0];
			int sy = cur[1];
			
			if (map[sx][sy] != 1) {
				continue;
			}
			
			map[sx][sy] = cnt;
			sum++;
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if (map[nx][ny] == 1) {
					q.add(new int[] {nx, ny});
				}
			}
		}
		
		sumArr[cnt] = sum;
		
	}

}