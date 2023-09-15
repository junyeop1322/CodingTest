import java.io.*;
import java.util.*;

public class Main {

	static int n, m, cnt;
	static int[][] map;
	static int[][] dik;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dik = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dik[i], Integer.MAX_VALUE);
		}
		
		dik[0][0] = map[0][0];
		
//		System.out.println(1);
		bfs();
//		System.out.println(2);
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(dik[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(dik[n-1][m-1]);
		
	}
	
	static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
//		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, dik[0][0]});
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int sx = a[0];
			int sy = a[1];
			
			if (sx == n-1 && sy == m-1) {
//				System.out.println(cnt);
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = sx + dx[i];
				int ny = sy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					int ans = 0;
					if (map[nx][ny] == 1) {
						ans = 1;
					}
					if (dik[nx][ny] > a[2] + ans) {
						dik[nx][ny] = a[2] + ans;
						q.add(new int[] {nx, ny, dik[nx][ny]});
					}
				}
			}
			
		}
		
		
	}

}
