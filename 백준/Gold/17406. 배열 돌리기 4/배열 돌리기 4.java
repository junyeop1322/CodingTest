import java.util.*;
import java.io.*;

public class Main {

	static int N, M, K;
	static int[][] arr;
	static int[][] map;
	static int min = Integer.MAX_VALUE;;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map = new int[K][3];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			map[k][0] = Integer.parseInt(st.nextToken()) - 1;
			map[k][1] = Integer.parseInt(st.nextToken()) - 1;
			map[k][2] = Integer.parseInt(st.nextToken());
		}
		
		perm(0, new int[K], new boolean[K]);
		
		System.out.println(min);
	}
	
	static int[][] copyArr() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}

	static void perm(int cnt, int[] res, boolean[] isSelec) {
		if (cnt == K) {
			rotate(res);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (isSelec[i]) continue;
			isSelec[i] = true;
			res[cnt] = i;
			perm(cnt+1, res, isSelec);
			isSelec[i] = false;
		}
	}
	
	static void rotate(int[] res) {
		int[][] tmp = copyArr();
		
		for (int k = 0; k < K; k++) {
			int r = map[res[k]][0];
			int c = map[res[k]][1];
			int S = map[res[k]][2];
			
			for (int s = 1; s <= S; s++) {
				
				int tempU = tmp[r-s][c+s];
				for (int y = c+s; y > c-s; y--) {
					tmp[r-s][y] = tmp[r-s][y-1];
				}
				
				int tempR = tmp[r+s][c+s];
				for (int x = r+s; x > r-s; x--) {
					tmp[x][c+s] = tmp[x-1][c+s];
				}
				tmp[r-s+1][c+s] = tempU;
				
				int tempL = tmp[r+s][c-s];
				for (int y = c-s; y < c+s; y++) {
					tmp[r+s][y] = tmp[r+s][y+1];
				}
				tmp[r+s][c+s-1] = tempR;
				
				for (int x = r-s; x < r+s; x++) {
					tmp[x][c-s] = tmp[x+1][c-s];
				}
				tmp[r+s-1][c-s] = tempL;
			}
		}
		
		answer(tmp);
	}
	
	static void answer(int[][] tmp) {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += tmp[i][j];
			}
			if (min > sum) {
				min = sum;
			}
		}
	}
}
