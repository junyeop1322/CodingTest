import java.util.*;

public class Main {

	static int space[][];
	static int white, green;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		space = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				space[i][j] = sc.nextInt();
			}
		}
		
		makeSpace(0, 0, N);
		System.out.println(white);
		System.out.println(green);
	}
	
	static void makeSpace(int sr, int sc, int size) {
		int sum = 0;
		for (int r = sr; r < sr+size; r++ ) {
			for (int c = sc; c < sc+size; c++) {
				sum += space[r][c];
			}
		}
		
		if (sum == 0) {
			white++;
		} else if (sum == size*size) {
			green++;
		} else {
			int half = size/2;
			makeSpace(sr, sc, half);
			makeSpace(sr, sc+half, half);
			makeSpace(sr+half, sc, half);
			makeSpace(sr+half, sc+half, half);
		}
	}

}
