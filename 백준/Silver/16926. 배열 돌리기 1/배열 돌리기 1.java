import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = Math.min(N, M) / 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < cnt; j++) {
				int temp = map[j][j];
				for (int k = j+1; k < M-j; k++) {
					map[j][k-1] = map[j][k];
				}
				for (int k = j+1; k < N-j; k++) {
					map[k-1][M-1-j] = map[k][M-1-j];
				}
				for (int k = M-2-j; k >= j; k--) {
					map[N-1-j][k+1] = map[N-1-j][k];
				}
				for (int k = N -2-j; k >= j; k--) {
					map[k+1][j] = map[k][j];
				}
				map[j+1][j] = temp;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
}
