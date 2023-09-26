import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int[][] map = new int[10][10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 1; i < 10; i++) {
			String s = br.readLine();
			for (int j = 1; j < 10; j++) {
				map[i][j] = s.charAt(j-1) - '0';
				if(map[i][j] == 0) {
					list.add(new int[] {i, j});
				}
			}
		}

		int size = list.size();
		int now = 0;

		b : while ( now < size) {
			int Y = list.get(now)[0];
			int X = list.get(now)[1];

			map[Y][X]++;
			a : while(true) {
				if(map[Y][X] > 9) {
					map[Y][X] = 0;
					now--;
					continue b;
				}
				for(int i = 1; i < 10; i++) {
					if ( map[Y][i] == map[Y][X] && i !=X ) {
						map[Y][X]++;
						if( map[Y][X] < 10 ) {
							continue a;
						} else {
							map[Y][X] = 0;
							now--;
							continue b;
						}
					}
				}

				for(int i = 1; i < 10; i++) {
					if ( map[i][X] == map[Y][X] && i !=Y ) {
						map[Y][X]++;
						if( map[Y][X] < 10 ) {
							continue a;
						} else {
							map[Y][X] = 0;
							now--;
							continue b;
						}
					}
				}

				for(int i = 1; i < 4; i++) {
					int tmpY = (Y-1)/3*3 +i;
					for(int j = 1; j < 4; j++) {
						int tmpX = (X-1)/3*3 +j;

						if ( map[tmpY][tmpX] == map[Y][X] && !(tmpY == Y && tmpX == X) ) {
							map[Y][X]++;
							if( map[Y][X] < 10 ) {
								continue a;
							} else {
								map[Y][X] = 0;
								now--;
								continue b;
							}
						}
					}
				}
				
				now++;
				break;
			}
		}

		        for (int i = 1; i < 10; i++) {
		            for (int j = 1; j < 10; j++) {
		                System.out.print(map[i][j]);
		            }
		            System.out.println();
		        }

	}
	
}