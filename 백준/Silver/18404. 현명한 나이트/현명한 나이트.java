import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	
	static int[][] map;
	
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		
		bfs(x, y);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int sx = Integer.parseInt(st.nextToken())-1;
			int sy = Integer.parseInt(st.nextToken())-1;
			
			sb.append(map[sx][sy] + " ");
		}

		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		
		q.add(new int[] {x, y, 0});
		visited[x][y] = true;
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int sx = cur[0];
			int sy = cur[1];
			int count = cur[2];
			
			
			for (int i = 0; i < 8; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if (!visited[nx][ny]) {
					q.add(new int[] {nx, ny, count+1});
					map[nx][ny] = count+1;
					visited[nx][ny] = true;
				}
			}
		}
		
	}

}

