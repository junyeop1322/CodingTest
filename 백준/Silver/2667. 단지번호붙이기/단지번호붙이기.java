import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map;
	static int N;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1};// 상하좌우
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int cntA = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt = 0;
				if (map[i][j] == 1 && visit[i][j] == false) {
					dfs(i, j);
					cntA++;
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(cntA);
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		cnt++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == 1 && visit[nx][ny] == false) {
					dfs(nx, ny);
				}
			}
			
		}
		
	}

}
