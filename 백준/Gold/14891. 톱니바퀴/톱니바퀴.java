import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int k = Integer.parseInt(br.readLine());
		
		for (int o = 0; o < k; o++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int vec = Integer.parseInt(st.nextToken());

			switch (num) {
			case 1:
				if (arr[0][2] != arr[1][6]) {
					if (arr[1][2] != arr[2][6]) {
						if (arr[2][2] != arr[3][6]) {
							if (vec == 1) {
								arr[0] = rotate(arr[0]);
								arr[1] = rotateRe(arr[1]);
								arr[2] = rotate(arr[2]);
								arr[3] = rotateRe(arr[3]);
							} else {
								arr[0] = rotateRe(arr[0]);
								arr[1] = rotate(arr[1]);
								arr[2] = rotateRe(arr[2]);
								arr[3] = rotate(arr[3]);
							}
						} else {
							if (vec == 1) {
								arr[0] = rotate(arr[0]);
								arr[1] = rotateRe(arr[1]);
								arr[2] = rotate(arr[2]);
							} else {
								arr[0] = rotateRe(arr[0]);
								arr[1] = rotate(arr[1]);
								arr[2] = rotateRe(arr[2]);
							}
						}
					} else {
						if (vec == 1) {
							arr[0] = rotate(arr[0]);
							arr[1] = rotateRe(arr[1]);
						} else {
							arr[0] = rotateRe(arr[0]);
							arr[1] = rotate(arr[1]);
						}
					}
				} else {
					if (vec == 1) {
						arr[0] = rotate(arr[0]);
					} else {
						arr[0] = rotateRe(arr[0]);
					}
				}
				break;
			case 2:
				if (arr[1][2] != arr[2][6] && arr[1][6] != arr[0][2]) {
					if (arr[2][2] != arr[3][6]) {
						if (vec == 1) {
							arr[0] = rotateRe(arr[0]);
							arr[1] = rotate(arr[1]);
							arr[2] = rotateRe(arr[2]);
							arr[3] = rotate(arr[3]);
						} else {
							arr[0] = rotate(arr[0]);
							arr[1] = rotateRe(arr[1]);
							arr[2] = rotate(arr[2]);
							arr[3] = rotateRe(arr[3]);
						}
					} else {
						if (vec == 1) {
							arr[0] = rotateRe(arr[0]);
							arr[1] = rotate(arr[1]);
							arr[2] = rotateRe(arr[2]);
						} else {
							arr[0] = rotate(arr[0]);
							arr[1] = rotateRe(arr[1]);
							arr[2] = rotate(arr[2]);
						}
					}
				} else if (arr[1][2] != arr[2][6] && arr[1][6] == arr[0][2]) {
					if (arr[2][2] != arr[3][6]) {
						if (vec == 1) {
							arr[1] = rotate(arr[1]);
							arr[2] = rotateRe(arr[2]);
							arr[3] = rotate(arr[3]);
						} else {
							arr[1] = rotateRe(arr[1]);
							arr[2] = rotate(arr[2]);
							arr[3] = rotateRe(arr[3]);
						}
					} else {
						if (vec == 1) {
							arr[1] = rotate(arr[1]);
							arr[2] = rotateRe(arr[2]);
						} else {
							arr[1] = rotateRe(arr[1]);
							arr[2] = rotate(arr[2]);
						}
					}
				} else if (arr[1][2] == arr[2][6] && arr[1][6] != arr[0][2]) {
					if (vec == 1) {
						arr[0] = rotateRe(arr[0]);
						arr[1] = rotate(arr[1]);
					} else {
						arr[0] = rotate(arr[0]);
						arr[1] = rotateRe(arr[1]);
					}
				} else if (arr[1][2] == arr[2][6] && arr[1][6] == arr[0][2]) {
					if (vec == 1) {
						arr[1] = rotate(arr[1]);
					} else {
						arr[1] = rotateRe(arr[1]);
					}
				}
				break;
			case 3:
				if (arr[2][2] != arr[3][6] && arr[2][6] != arr[1][2]) {
					if (arr[1][6] != arr[0][2]) {
						if (vec == 1) {
							arr[0] = rotate(arr[0]);
							arr[1] = rotateRe(arr[1]);
							arr[2] = rotate(arr[2]);
							arr[3] = rotateRe(arr[3]);
						} else {
							arr[0] = rotateRe(arr[0]);
							arr[1] = rotate(arr[1]);
							arr[2] = rotateRe(arr[2]);
							arr[3] = rotate(arr[3]);
						}
					} else {
						if (vec == 1) {
							arr[1] = rotateRe(arr[1]);
							arr[2] = rotate(arr[2]);
							arr[3] = rotateRe(arr[3]);
						} else {
							arr[1] = rotate(arr[1]);
							arr[2] = rotateRe(arr[2]);
							arr[3] = rotate(arr[3]);
						}
					}
				} else if (arr[2][2] == arr[3][6] && arr[2][6] != arr[1][2]) {
					if (arr[1][6] != arr[0][2]) {
						if (vec == 1) {
							arr[0] = rotate(arr[0]);
							arr[1] = rotateRe(arr[1]);
							arr[2] = rotate(arr[2]);
						} else {
							arr[0] = rotateRe(arr[0]);
							arr[1] = rotate(arr[1]);
							arr[2] = rotateRe(arr[2]);
						}
					} else {
						if (vec == 1) {
							arr[1] = rotateRe(arr[1]);
							arr[2] = rotate(arr[2]);
						} else {
							arr[1] = rotate(arr[1]);
							arr[2] = rotateRe(arr[2]);
						}
					}
				} else if (arr[2][2] != arr[3][6] && arr[2][6] == arr[1][2]) {
					if (vec == 1) {
						arr[2] = rotate(arr[2]);
						arr[3] = rotateRe(arr[3]);
					} else {
						arr[2] = rotateRe(arr[2]);
						arr[3] = rotate(arr[3]);
					}
				} else if (arr[2][2] == arr[3][6] && arr[2][6] == arr[1][2]) {
					if (vec == 1) {
						arr[2] = rotate(arr[2]);
					} else {
						arr[2] = rotateRe(arr[2]);
					}
				}
				break;
			case 4:
				if (arr[3][6] != arr[2][2]) {
					if (arr[2][6] != arr[1][2]) {
						if (arr[1][6] != arr[0][2]) {
							if (vec == 1) {
								arr[0] = rotateRe(arr[0]);
								arr[1] = rotate(arr[1]);
								arr[2] = rotateRe(arr[2]);
								arr[3] = rotate(arr[3]);
							} else {
								arr[0] = rotate(arr[0]);
								arr[1] = rotateRe(arr[1]);
								arr[2] = rotate(arr[2]);
								arr[3] = rotateRe(arr[3]);
							}
						} else {
							if (vec == 1) {
								arr[1] = rotate(arr[1]);
								arr[2] = rotateRe(arr[2]);
								arr[3] = rotate(arr[3]);
							} else {
								arr[1] = rotateRe(arr[1]);
								arr[2] = rotate(arr[2]);
								arr[3] = rotateRe(arr[3]);
							}
						}
					} else {
						if (vec == 1) {
							arr[2] = rotateRe(arr[2]);
							arr[3] = rotate(arr[3]);
						} else {
							arr[2] = rotate(arr[2]);
							arr[3] = rotateRe(arr[3]);
						}
					}
				} else {
					if (vec == 1) {
						arr[3] = rotate(arr[3]);
					} else {
						arr[3] = rotateRe(arr[3]);
					}
				}

				break;
			}

//				for (int i = 0; i < 4; i++) {
//					for (int j = 0; j < 8; j++) {
//						System.out.print(arr[i][j] + " ");
//					}
//					System.out.println();
//				}

		}

		int ans = 0;
		if (arr[0][0] == 1) {
			ans += 1;
		}
		if (arr[1][0] == 1) {
			ans += 2;
		}
		if (arr[2][0] == 1) {
			ans += 4;
		}
		if (arr[3][0] == 1) {
			ans += 8;
		}

		System.out.println(ans);
	}

	static int[] rotateRe(int[] arr) { // 반시계
		int temp = arr[0];
		for (int i = 0; i < 7; i++) {
			arr[i] = arr[i + 1];
		}
		arr[7] = temp;

		return arr;
	}

	static int[] rotate(int[] arr) { // 시계
		int temp = arr[7];
		for (int i = 7; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;

		return arr;
	}

}
