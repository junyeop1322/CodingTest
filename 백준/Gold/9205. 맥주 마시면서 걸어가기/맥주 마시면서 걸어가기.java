import java.io.*;
import java.util.*;

public class Main {

	static int n, sx, sy, dx, dy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			int[][] shop = new int[n][2];
			
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken()); // 상근쓰
			sy = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				shop[i][0] = Integer.parseInt(st.nextToken());
				shop[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			dx = Integer.parseInt(st.nextToken()); // 도착쓰
			dy = Integer.parseInt(st.nextToken());
			
			if (bfs(shop)) {
				sb.append("happy").append("\n");
			} else {
				sb.append("sad").append("\n");
			}
			
		}
		
		System.out.println(sb);
	}
	
	static boolean bfs(int[][] shop) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sx, sy});
		boolean[] visit = new boolean[n];
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			int x = a[0];
			int y = a[1];
			
			if (Math.abs(x - dx) + Math.abs(y - dy) <= 1000) {
				return true;
			}
			
			for(int i = 0; i < n; i++) {
				if (!visit[i]) {
					int nx = shop[i][0];
					int ny = shop[i][1];
					
					int distance = Math.abs(x - nx) + Math.abs(y - ny);
					if (distance <= 1000) {
						visit[i] = true;
						q.add(new int[] {nx, ny});
					}
					
				}
			}
			
		}
		
		return false;
	}

}
