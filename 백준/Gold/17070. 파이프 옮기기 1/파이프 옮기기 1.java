import java.io.*;
import java.util.*;

public class Main {

	static int n, cnt;
	static int[][] map;
	static int[] move1 = {};
	static int[] move2 = {};
	static int[] move3 = {};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		
		cnt = 0;
		int[] a = {0, 0};
		int[] b = {0, 1};
		dfs(a, b);
		
		
		System.out.println(cnt);
	}
	
	static void dfs(int[] arr, int[] brr) {
		int a = arr[0]; // 뒤 파이프 x
		int b = arr[1]; // 뒤 파이프 y
		int c = brr[0]; // 앞 파이프 x
		int d = brr[1]; // 앞 파이프 y
		
		if (c == n-1 && d == n-1) {
			cnt++;
			return;
		}
		
		if (a == c && d - b == 1) { // 가로
			if (d + 1 < n && map[c][d+1] != 1) {
				dfs(new int[] {a, b+1}, new int[] {c, d+1});
			}
			
			if (c + 1 < n && d + 1 < n) {
				if (map[c][d+1] != 1 && map[c+1][d] != 1 && map[c+1][d+1] != 1) {
					dfs(new int[] {a, b+1}, new int[] {c+1, d+1});
				}
			}
			
		}
		
		if (b == d && c - a == 1) { // 세로
			if (c + 1 < n && map[c+1][d] != 1) {
				dfs(new int[] {a+1, b}, new int[] {c+1, d});
			}
			
			if (c + 1 < n && d + 1 < n) {
				if (map[c][d+1] != 1 && map[c+1][d] != 1 && map[c+1][d+1] != 1) {
					dfs(new int[] {a+1, b}, new int[] {c+1, d+1});
				}
			}
			
		}
		
		if (c - a == 1 && d - b == 1) { // 대각선
			if (d+1 < n && map[c][d+1] != 1) {
				dfs(new int[] {a+1, b+1}, new int[] {c, d+1});
			}
			
			if (c+1 < n && map[c+1][d] != 1) {
				dfs(new int[] {a+1, b+1}, new int[] {c+1, d});
			}
			
			if (c + 1 < n && d + 1 < n) {
				if (map[c][d+1] != 1 && map[c+1][d] != 1 && map[c+1][d+1] != 1) {
					dfs(new int[] {a+1, b+1}, new int[] {c+1, d+1});
				}
			}
			
		}
		
	}

}
