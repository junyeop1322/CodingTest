import java.io.*;
import java.util.*;

public class Main {
	
	static int n, l;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (col(i)) {
				ans++;
			}
			
			if (row(i)) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean col(int num) {
		boolean[] chk = new boolean[n];
		
		for (int i = 0; i < n-1; i++) {
			int diff = map[i][num] - map[i+1][num];
			
			if (diff > 1 || diff < -1) {
				return false;
			} else if (diff == -1) {
				for (int j = 0; j < l; j++) {
					if (i-j < 0 || chk[i-j]) {
						return false;
					}
					
					if (map[i][num] != map[i-j][num]) {
						return false;
					}
					
					chk[i-j] = true;
				}
			} else if (diff == 1) {
				for (int j = 1; j <= l; j++) {
					if (i+j >= n || chk[i+j]) {
						return false;
					}
					
					if (map[i][num] -1 != map[i+j][num]) {
						return false;
					}
					
					chk[i+j] = true;
				}
			}
		}
		
		return true;
	}
	
	static boolean row(int num) {
		boolean[] chk = new boolean[n];
		
		for (int i = 0; i < n-1; i++) {
			int diff = map[num][i] - map[num][i+1];
			
			if (diff > 1 || diff < -1) {
				return false;
			} else if (diff == -1) {
				for (int j = 0; j < l; j++) {
					if (i-j < 0 || chk[i-j]) {
						return false;
					}
					
					if (map[num][i] != map[num][i-j]) {
						return false;
					}
					
					chk[i-j] = true;
				}
			} else if (diff == 1) {
				for (int j = 1; j <= l; j++) {
					if (i+j >= n || chk[i+j]) {
						return false;
					}
					
					if (map[num][i] -1 != map[num][i+j]) {
						return false;
					}
					
					chk[i+j] = true;
				}
			}
		}
		
		return true;
	}

}
