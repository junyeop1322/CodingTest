import java.io.*;
import java.util.*;

public class Main {

	static int one = 0;
	static int minus = 0;
	static int zero = 0;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeSpace(0, 0, N);

		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);

	}

	static void makeSpace(int sr, int sc, int size) {
		int Zcnt = 0;
		int Mcnt = 0;
		int Ocnt = 0;

		for (int r = sr; r < sr + size; r++) {
			for (int c = sc; c < sc + size; c++) {
				if (map[r][c] == 0) {
					Zcnt++;
				} else if (map[r][c] == 1) {
					Ocnt++;
				} else if (map[r][c] == -1) {
					Mcnt++;
				}
			}
		}

		if (Zcnt == size * size) {
			zero++;
		} else if (Ocnt == size * size) {
			one++;
		} else if (Mcnt == size * size) {
			minus++;
		} else {
			int nSize = size / 3;
			makeSpace(sr, sc, nSize);
			makeSpace(sr, sc + nSize, nSize);
			makeSpace(sr, sc + (2 * nSize), nSize);
			makeSpace(sr + nSize, sc, nSize);
			makeSpace(sr + nSize, sc + nSize, nSize);
			makeSpace(sr + nSize, sc + (2 * nSize), nSize);
			makeSpace(sr + (2 * nSize), sc, nSize);
			makeSpace(sr + (2 * nSize), sc + nSize, nSize);
			makeSpace(sr + (2 * nSize), sc + (2 * nSize), nSize);
		}
	}

}
