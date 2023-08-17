import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[] visit;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = N/2;
		visit = new boolean[N];
		min = Integer.MAX_VALUE;
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		
		System.out.println(min);
	}

	static void comb(int cnt, int start) {
		if (cnt == M) {
			diff();
			return;
		}
		
		for (int i = start; i < N; i++) {
			visit[i] = true;
			comb(cnt+1, i+1);
			visit[i] = false;
		}
	}
	
	static void diff() {
		int link = 0;
		int start = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i] == false && visit[j] == false) {
					link += map[i][j] + map[j][i];
				} else if (visit[i] == true && visit[j] == true) {
					start += map[i][j] + map[j][i];
				}
			}
		}
		int val = Math.abs(link - start) / 2;
		if (min > val) {
			min = val;
		}
		
	}
	
}
