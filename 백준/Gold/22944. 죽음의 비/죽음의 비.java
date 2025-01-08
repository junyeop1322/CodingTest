import java.io.*;
import java.util.*;

public class Main {
	
	static int n,h,d;
	static char[][] map;
	static int[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Node{
		int x, y, h, cost, cnt;
		public Node(int x, int y, int h, int cost, int cnt) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.cost = cost;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new char[n][n];
		check = new int[n][n];
		
		int r = 0;
		int c = 0;
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					r = i;
					c = j;
				}
			}
		}
		
		int ans = bfs(r, c);
		System.out.println(ans);
	}
	
	public static int bfs(int sx, int sy) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy, h, 0, 0));
		check[sx][sy] = h;
		
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int hp = cur.h, cost=cur.cost, cnt=cur.cnt;
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if (map[nx][ny] == 'E') {
					min = Math.min(min, cnt+1);
					continue;
				}
				
				if (map[nx][ny] == 'U') {
					cost = d;
				}
				
				if (cost != 0) {
					cost--;
				} else {
					hp--;
				}
				
				if (hp == 0) {
					continue;
				}
				
				if (check[nx][ny] < hp + cost) {
					check[nx][ny] = hp + cost;
					q.add(new Node(nx, ny, hp, cost, cnt+1));
				}
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			return -1;
		}
		
		return min;
	}

}
