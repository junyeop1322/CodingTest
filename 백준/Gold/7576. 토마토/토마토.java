import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	static Queue<int[]> q = new LinkedList<>();
	
	// 4방향 탐색 상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q.add(new int[]{i, j});
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int x = t[0];
			int y = t[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if (arr[nx][ny] == 0) {
					arr[nx][ny] = arr[x][y] + 1;
					q.add(new int[]{nx, ny});
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		if (checkZero()) {
			return -1;
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] > max) {
						max = arr[i][j];
					}
				}
			}
			return (max - 1);
		}
				
	}
	
	
	private static boolean checkZero() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}

}
