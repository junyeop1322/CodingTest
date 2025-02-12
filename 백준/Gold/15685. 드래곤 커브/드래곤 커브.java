import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[][] map = new boolean[101][101];
	static List<Integer> list;
	
	static int n;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			list = new LinkedList<Integer>();
			add(d, g);
			dragon(x, y);
		}

		int ans = countDragon();
		
		System.out.println(ans);
	}
	
	static void add(int d, int g) {
		list.add(d);
		
		for (int i = 1; i <= g; i++) {
			for (int j = list.size()-1; j >= 0; j--) {
				list.add((list.get(j)+1) % 4);
			}
		}
	}
	
	static void dragon(int x, int y) {
		map[x][y] = true;
		
		int nx = x;
		int ny = y;
		
		for (int i = 0; i < list.size(); i++) {
			int d = list.get(i);
			
			nx += dx[d];
			ny += dy[d];
			
			map[nx][ny] = true;
		}
	}
	
	static int countDragon() {
		int cnt = 0;
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}
