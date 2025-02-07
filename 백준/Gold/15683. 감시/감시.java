import java.io.*;
import java.util.*;

public class Main {
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static int[][][] mode = {{{0}}, {{0}, {1}, {2}, {3}}, {{2, 3}, {0, 1}},
			{{0, 3}, {1, 3}, {1, 2}, {0, 2}},
			{{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
			{{0, 1, 2, 3}}};
	
	public static ArrayList<Node> cctv;
	public static class Node {
		int x;
		int y;
		int type;
		public Node(int x, int y, int type) {
			this.x= x;
			this.y= y;
			this.type = type;
		}
	}
	
	
	public static int n, m, ans;
	public static int[][] map;	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cctv = new ArrayList<>();
		
		int num = 0;
		int[][] map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5){
					cctv.add(new Node(i, j, map[i][j]));
				} else if (map[i][j] == 0) {
					num++;
				}
			}
		}
		
		ans = num;
		comb(0, cctv.size(), map);
		
		System.out.println(ans);
	}
	
	
	static void comb (int depth, int r, int[][] map) {
		if (depth == r) {
			int cnt = check(map);
			ans = Math.min(ans, cnt);
			
			return;
		}
		
		int type = cctv.get(depth).type;
		int x = cctv.get(depth).x;
		int y = cctv.get(depth).y;
		
		
		for (int i = 0; i < mode[type].length; i++) {
			int[][] copy = new int[n][m];
			for (int k = 0; k < n; k++) {
				copy[k] = map[k].clone();
			}
			
			for (int j = 0; j < mode[type][i].length; j++) {
				int dir = mode[type][i][j];
		
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				while (true) {
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						break;
					}
					
					if (map[nx][ny] == 6) {
						break;
					}
					
					copy[nx][ny] = -1;
					nx += dx[dir];
					ny += dy[dir];
				}
			}
			
			comb(depth+1, r, copy);
		}
	}
	
	static int check (int[][] map) {
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	
	

}