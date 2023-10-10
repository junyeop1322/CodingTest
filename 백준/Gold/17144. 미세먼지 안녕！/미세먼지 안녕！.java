import java.io.*;
import java.util.*;

public class Main {

	static int n, m, t;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		int r = 0;
		int c = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					r = i;
					c = j;
				}
			}
		}
		
		for (int i = 0; i < t; i++) {
			dust();
			clean(r, c);
			
//			for(int dr = 0; dr < n; dr++) {
//				for (int dc = 0; dc < m; dc++) {
//					System.out.print(map[dr][dc] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		
		System.out.println(count());
		
	}
	
	static void dust() {
		int[][] visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] > 0) {
					visit[i][j] = map[i][j];
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j] != 0) {
					int cnt = 0;
					int num = visit[i][j] / 5;
					
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
							if (map[nx][ny] != -1) {
								cnt++;
								map[nx][ny] += num;
							}
						}
					}
					
					map[i][j] -= cnt*num;
				}
			}
		}
	}
	
	static void clean(int r, int c) {
		int nr = r-1;
		
		for (int i = r+1; i < n-1; i++) {
			map[i][c] = map[i+1][c];
		}
		for (int i = nr-1; i > 0; i--) {
			map[i][c] = map[i-1][c];
		}
		
		for (int i = c; i < m-1; i++) {
			map[0][i] = map[0][i+1];
			map[n-1][i] = map[n-1][i+1];
		}
		
		for (int i = 0; i < nr; i++) {
			map[i][m-1] = map[i+1][m-1];
		}
		for (int i = n-1; i > r; i--) {
			map[i][m-1] = map[i-1][m-1];
		}
		
		for (int i = m-1; i > c; i--) {
			map[r][i] = map[r][i-1];
			map[nr][i] = map[nr][i-1];
		}
		
		map[r][c+1] = 0;
		map[nr][c+1] = 0;
	}

	static int count() {
		int cnt = 2;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cnt += map[i][j];
			}
		}
		
		return cnt;
	}
}
