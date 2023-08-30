import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n+1][m+1];
		int max = -1;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				max = Math.max(map[i-1][j], Math.max(map[i][j-1], map[i-1][j-1]));
				map[i][j] += max;
			}
		}
		
		System.out.println(map[n][m]);

	}

	

}
