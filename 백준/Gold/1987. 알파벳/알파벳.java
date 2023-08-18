import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static char[][] map;
	static int max;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Character> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		max = Integer.MIN_VALUE;
		
		dfs(0, 0, 0);		
		
		System.out.println(max);
	}
	
	static void dfs (int x, int y, int count) {
		
		if(list.contains(map[x][y])) {
			if (max < count) {
				max = count;
			}
			return;
		}
		list.add(map[x][y]);
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				dfs(nx, ny, count+1);
			}
		}
		
		list.remove(Character.valueOf(map[x][y]));
	}

}
