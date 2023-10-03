import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static int[][] wall;
	static int[] dx = {-1, 1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[8][8];
		
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		map[7][0] = 'c';
		
		int cnt = 0;
		int ans = 0;
		
		while(true) {
			if (cnt >= 8) {
				if (check()) {
					ans = 1;
				} else {
					ans = 0;
				}
				break;
			}
			
			movePerson();
			moveWall();
			
//			for(int i = 0; i < 8; i++) {
//				for (int j = 0; j < 8; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("==============");
			
			cnt++;
		}
		
		System.out.println(ans);
	}
	
	static boolean check() {
		
		for(int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == 'c') {
					return true;
				}
			}
		}
		
		return false;
	}
	
	static void movePerson() {
		int[][] arr = new int[8][8];
		
		for(int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == 'c') {
					for (int d = 0; d < 8; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if (nx >= 0 && ny >= 0 && nx < 8 && ny < 8) {
							if (map[nx][ny] == '.') {
								arr[nx][ny] = 1;
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (arr[i][j] == 1) {
					map[i][j] = 'c';
				}
			}
		}
		
	}
	
	static void moveWall() {
		wall = new int[8][8];
		
		for(int i = 0; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == '#') {
					wall[i+1][j] = 2;
				}
			}
		}
		
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == '#') {
					map[i][j] = '.';
				}
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (wall[i][j] == 2) {
					map[i][j] = '#';
				}
			}
		}
		
	}

}
