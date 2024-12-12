import java.io.*;
import java.util.*;


public class Main {
	
	static int n, m;
	static int[][] map;
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int shark = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		map = new int[n][m];
		
		for (int i = 1; i <= shark; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			
			int s = Integer.parseInt(st.nextToken()); // 이동 속도
			int d = Integer.parseInt(st.nextToken()); // 이동 방향
			int z = Integer.parseInt(st.nextToken()); // 상어 크기
			
			map[r][c] = i;
			
			list.add(new int[] {i, r, c, s, d, z});
		}
		
		for (int t = 0; t < m; t++) {
			ans += getPoint(t);
			move();
		}
		
		System.out.println(ans);
	}
	
	static int getPoint(int t) {
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			if (map[i][t] != 0) {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j)[0] == map[i][t]) {
						cnt += list.get(j)[5];
						list.remove(j);
						map[i][t] = 0;
						
						break;
					}
				}
				
				break;
			}
		}
		
		return cnt;
	}
	
	static void move() {
	    int[][] nextMap = new int[n][m];
	    ArrayList<int[]> nextList = new ArrayList<>();

	    for (int[] cur : list) {
	        int id = cur[0];
	        int r = cur[1];
	        int c = cur[2];
	        int s = cur[3];
	        int d = cur[4];
	        int z = cur[5];

	        // 속도 최적화
	        if (d == 1 || d == 2) s %= (2 * (n - 1));
	        else s %= (2 * (m - 1));

	        // 이동
	        for (int i = 0; i < s; i++) {
	            if (d == 1 && r == 0) d = 2;
	            if (d == 2 && r == n - 1) d = 1;
	            if (d == 3 && c == m - 1) d = 4;
	            if (d == 4 && c == 0) d = 3;

	            if (d == 1) r--;
	            else if (d == 2) r++;
	            else if (d == 3) c++;
	            else if (d == 4) c--;
	        }

	        // 새로운 위치에 상어 추가
	        if (nextMap[r][c] == 0) {
	            nextMap[r][c] = id;
	            nextList.add(new int[] {id, r, c, s, d, z});
	        } else {
	            // 겹친 상어 처리
	            for (int j = 0; j < nextList.size(); j++) {
	                if (nextList.get(j)[0] == nextMap[r][c]) {
	                    if (nextList.get(j)[5] < z) {
	                        nextList.set(j, new int[] {id, r, c, s, d, z});
	                        nextMap[r][c] = id;
	                    }
	                    break;
	                }
	            }
	        }
	    }

	    list = nextList;
	    map = nextMap;
	}
}