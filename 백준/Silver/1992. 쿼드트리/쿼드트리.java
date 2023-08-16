import java.util.*;

public class Main {

	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		int N = sc.nextInt();
		map = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = (int)(s.charAt(j) - '0');
			}
		}
		
		quadTree(0, 0, N);
		System.out.println(sb);
		sc.close();
	}

	static void quadTree(int sr, int sc, int size) {
		int sum = 0;
		
		for (int r = sr; r < sr + size; r++) {
			for (int c = sc; c < sc + size; c++) {
				sum += map[r][c];
			}
		}
		
		if (sum == 0) {
			sb.append("0");
		} else if (sum == size*size) {
			sb.append("1");
		} else {
			sb.append("(");
			int half = size/2;
			quadTree(sr, sc, half);
			quadTree(sr, sc+half, half);
			quadTree(sr+half, sc, half);
			quadTree(sr+half, sc+half, half);
			sb.append(")");
		}
	}
	
}
