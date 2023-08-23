import java.io.*;
import java.util.*;

public class Solution {
	
	static int n, m, L;
	static int[][] map;
	static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			visit = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(r, c);
			
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visit[i][j] >= 1 && visit[i][j] <= L) {
						cnt++;
					}
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		visit[x][y] = 1;
		int[] a = {x, y};
		que.offer(a);
		
		while(!que.isEmpty()) {
			int[] b = que.poll();
			int sx = b[0];
			int sy = b[1];
			
			switch(map[sx][sy]) {
			case 1:
				if (sx+1 < n) { // 하
					if(map[sx+1][sy] != 0 && map[sx+1][sy] != 3 && map[sx+1][sy] != 5 && map[sx+1][sy] != 6) {
						if (visit[sx+1][sy] == 0) {
							visit[sx+1][sy] = visit[sx][sy]+1;
							int[] c = {sx+1, sy};
							que.offer(c);
						}
					}
				}
				if (sx-1 >= 0) { // 상
					if(map[sx-1][sy] != 0 && map[sx-1][sy] != 3 && map[sx-1][sy] != 4 && map[sx-1][sy] != 7) {
						if (visit[sx-1][sy] == 0) {
							visit[sx-1][sy] = visit[sx][sy]+1;
							int[] c = {sx-1, sy};
							que.offer(c);
						}
					}
				}
				if (sy+1 < m) { // 우
					if(map[sx][sy+1] != 0 && map[sx][sy+1] != 2 && map[sx][sy+1] != 4 && map[sx][sy+1] != 5) {
						if (visit[sx][sy+1] == 0) {
							visit[sx][sy+1] = visit[sx][sy]+1;
							int[] c = {sx, sy+1};
							que.offer(c);
						}
					}
				}
				if (sy-1 >= 0) { // 좌
					if(map[sx][sy-1] != 0 && map[sx][sy-1] != 2 && map[sx][sy-1] != 6 && map[sx][sy-1] != 7) {
						if (visit[sx][sy-1] == 0) {
							visit[sx][sy-1] = visit[sx][sy]+1;
							int[] c = {sx, sy-1};
							que.offer(c);
						}
					}
				}
				break;
			case 2:
				if (sx+1 < n) { // 하
					if(map[sx+1][sy] != 0 && map[sx+1][sy] != 3 && map[sx+1][sy] != 5 && map[sx+1][sy] != 6) {
						if (visit[sx+1][sy] == 0) {
							visit[sx+1][sy] = visit[sx][sy]+1;
							int[] c = {sx+1, sy};
							que.offer(c);
						}
					}
				}
				if (sx-1 >= 0) { // 상
					if(map[sx-1][sy] != 0 && map[sx-1][sy] != 3 && map[sx-1][sy] != 4 && map[sx-1][sy] != 7) {
						if (visit[sx-1][sy] == 0) {
							visit[sx-1][sy] = visit[sx][sy]+1;
							int[] c = {sx-1, sy};
							que.offer(c);
						}
					}
				}
				
				break;
			case 3:
				if (sy+1 < m) { // 우
					if(map[sx][sy+1] != 0 && map[sx][sy+1] != 2 && map[sx][sy+1] != 4 && map[sx][sy+1] != 5) {
						if (visit[sx][sy+1] == 0) {
							visit[sx][sy+1] = visit[sx][sy]+1;
							int[] c = {sx, sy+1};
							que.offer(c);
						}
					}
				}
				if (sy-1 >= 0) { // 좌
					if(map[sx][sy-1] != 0 && map[sx][sy-1] != 2 && map[sx][sy-1] != 6 && map[sx][sy-1] != 7) {
						if (visit[sx][sy-1] == 0) {
							visit[sx][sy-1] = visit[sx][sy]+1;
							int[] c = {sx, sy-1};
							que.offer(c);
						}
					}
				}
				break;
			case 4:
				if (sx-1 >= 0) { // 상
					if(map[sx-1][sy] != 0 && map[sx-1][sy] != 3 && map[sx-1][sy] != 4 && map[sx-1][sy] != 7) {
						if (visit[sx-1][sy] == 0) {
							visit[sx-1][sy] = visit[sx][sy]+1;
							int[] c = {sx-1, sy};
							que.offer(c);
						}
					}
				}
				if (sy+1 < m) { // 우
					if(map[sx][sy+1] != 0 && map[sx][sy+1] != 2 && map[sx][sy+1] != 4 && map[sx][sy+1] != 5) {
						if (visit[sx][sy+1] == 0) {
							visit[sx][sy+1] = visit[sx][sy]+1;
							int[] c = {sx, sy+1};
							que.offer(c);
						}
					}
				}
				break;
			case 5:
				if (sx+1 < n) { // 하
					if(map[sx+1][sy] != 0 && map[sx+1][sy] != 3 && map[sx+1][sy] != 5 && map[sx+1][sy] != 6) {
						if (visit[sx+1][sy] == 0) {
							visit[sx+1][sy] = visit[sx][sy]+1;
							int[] c = {sx+1, sy};
							que.offer(c);
						}
					}
				}
				if (sy+1 < m) { // 우
					if(map[sx][sy+1] != 0 && map[sx][sy+1] != 2 && map[sx][sy+1] != 4 && map[sx][sy+1] != 5) {
						if (visit[sx][sy+1] == 0) {
							visit[sx][sy+1] = visit[sx][sy]+1;
							int[] c = {sx, sy+1};
							que.offer(c);
						}
					}
				}
				break;
			case 6:
				if (sx+1 < n) { // 하
					if(map[sx+1][sy] != 0 && map[sx+1][sy] != 3 && map[sx+1][sy] != 5 && map[sx+1][sy] != 6) {
						if (visit[sx+1][sy] == 0) {
							visit[sx+1][sy] = visit[sx][sy]+1;
							int[] c = {sx+1, sy};
							que.offer(c);
						}
					}
				}
				if (sy-1 >= 0) { // 좌
					if(map[sx][sy-1] != 0 && map[sx][sy-1] != 2 && map[sx][sy-1] != 6 && map[sx][sy-1] != 7) {
						if (visit[sx][sy-1] == 0) {
							visit[sx][sy-1] = visit[sx][sy]+1;
							int[] c = {sx, sy-1};
							que.offer(c);
						}
					}
				}
				break;
			case 7:
				if (sx-1 >= 0) { // 상
					if(map[sx-1][sy] != 0 && map[sx-1][sy] != 3 && map[sx-1][sy] != 4 && map[sx-1][sy] != 7) {
						if (visit[sx-1][sy] == 0) {
							visit[sx-1][sy] = visit[sx][sy]+1;
							int[] c = {sx-1, sy};
							que.offer(c);
						}
					}
				}
				if (sy-1 >= 0) { // 좌
					if(map[sx][sy-1] != 0 && map[sx][sy-1] != 2 && map[sx][sy-1] != 6 && map[sx][sy-1] != 7) {
						if (visit[sx][sy-1] == 0) {
							visit[sx][sy-1] = visit[sx][sy]+1;
							int[] c = {sx, sy-1};
							que.offer(c);
						}
					}
				}
				break;
			}
			
		}
		
	}

}
