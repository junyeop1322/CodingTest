import java.io.*;
import java.util.*;

public class Main {
	
	static int size;
	static int[][] chess;
	
	static int[] dx = {-1, -1, 1, 1};
	static int[] dy = {-1, 1, -1, 1};
	
	static int bCnt = 0;
	static int wCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		
		chess = new int[size+1][size+1];
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < size; j++) {
				chess[i+1][j+1] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] bVisit = new boolean[size+1][size+1];
		black(bVisit, 1, 1, 0);
		
		boolean[][] wVisit = new boolean[size+1][size+1];
		white(wVisit, 1, 2, 0);
		
		System.out.println(bCnt+wCnt);
	}
	
	static void black(boolean[][] visit, int x, int y, int cnt) {
		bCnt = Math.max(cnt, bCnt);
		
		if (y > size) {
			x += 1;
			y = (x % 2 == 0) ? 2 : 1;
		}
		
		if (x > size) {
			return;
		}
		
		if (check(visit, x, y)) {
			visit[x][y] = true;
			black(visit, x, y+2, cnt+1);
			visit[x][y] = false;
		}
		
		black(visit, x, y+2, cnt);
	}
	
	static void white(boolean[][] visit, int x, int y, int cnt) {
		wCnt = Math.max(cnt, wCnt);
		
		if (y > size) {
			x += 1;
			y = (x % 2 == 0) ? 1 : 2;
		}
		
		if (x > size) {
			return;
		}
		
		if (check(visit, x, y)) {
			visit[x][y] = true;
			white(visit, x, y+2, cnt+1);
			visit[x][y] = false;
		}
		
		white(visit, x, y+2, cnt);
	}
	

	
	static boolean check(boolean[][]visit, int x, int y) {
		if (chess[x][y] == 0) {
			return false;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			for (int j = 1; j <= size; j++) {
				if (nx > 0 && ny > 0 && nx <= size && ny <= size) {
					if (visit[nx][ny]) {
						return false;
					}
					
					nx += dx[i];
					ny += dy[i];
				}
			}
		}
		
		return true;
	}
	
}
