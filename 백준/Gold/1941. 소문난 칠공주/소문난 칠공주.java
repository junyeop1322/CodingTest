import java.io.*;
import java.util.*;

public class Main {

	static int ans, cnt;
	static char[][] map;
	static boolean[] visit;
	static int[] select;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		visit = new boolean[25];
		select = new int[7];
		
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		ans = 0;
		
		dfs(0, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int num, int s) {
		if (num == 7) {
			if(check()) {
				ans++;
			}
			return;
		}
		
		for (int i = s; i < 25; i++) {
			if(!visit[i]) {
				visit[i] = true;
				select[num] = i;
				dfs(num+1, i+1);
				visit[i] = false;
			}
		}
	}
	
	static boolean check() {
		int y = 0;
		for (int i : select) {
			if(map[i/5][i%5] == 'Y') {
				y++;
			}
		}
		
		if (y > 3) {
			return false;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int a : select) {
			list.add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(select[0]);
		while(!q.isEmpty()) {
			int c = q.poll();
			int sx = c/5;
			int sy = c%5;
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
					if (list.contains(nx * 5 + ny)) {
						list.remove(Integer.valueOf(nx * 5 + ny));
						q.add(nx * 5 + ny);
					}
				}
			}
		}
		
		if (!list.isEmpty()) {
			return false;
		}
		
		return true;
	}

}
