import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[][] arr = new int[5][5];
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, arr[i][j], 0);
			}
		}
		
		System.out.println(set.size());
	}

	static void dfs(int x, int y, int num, int cnt) {
		if (cnt == 5) {
			set.add(num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
				continue;
			}
			
			dfs(nx, ny, num*10 + arr[nx][ny], cnt+1);
		}
	}
}
