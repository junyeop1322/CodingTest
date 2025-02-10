import java.io.*;

public class Main {

	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];

		star(0, 0, n, false);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void star(int x, int y, int n, boolean chk) {
		if (chk) {
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					map[i][j] = ' ';
				}
			}
			
			return;
		}
		
		if (n == 1) {
			map[x][y] = '*';
			
			return;
		}
		
		int size = n / 3;
		int cnt = 0;
		
		for (int i = x; i < n + x; i += size) {
			for (int j = y; j < n + y; j += size) {
				cnt++;
				
				if (cnt == 5) {
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
		
	}

}
