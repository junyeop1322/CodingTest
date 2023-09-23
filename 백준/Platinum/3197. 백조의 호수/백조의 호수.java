//import java.io.*;
//import java.util.*;
//
//public class boj3197 {
//
//	static class Node {
//		int x, y;
//
//		Node(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}
//
//	static Queue<Node> q;
//	static Queue<Node> water;
//	static Node[] swan;
//	static int n, m;
//	static char[][] map;
//	static boolean[][] visit;
//	static int[] dx = { -1, 1, 0, 0 };
//	static int[] dy = { 0, 0, -1, 1 };
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		st = new StringTokenizer(br.readLine());
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//
//		map = new char[n][m];
//		visit = new boolean[n][m];
//		swan = new Node[2];
//		water = new LinkedList<>();
//		q = new LinkedList<>();
//
//		int idx = 0;
//		for (int i = 0; i < n; i++) {
//			String str = br.readLine();
//			for (int j = 0; j < m; j++) {
//				map[i][j] = str.charAt(j);
//				if (map[i][j] == 'L') {
//					swan[idx++] = new Node(i, j);
//				}
//				if (map[i][j] != 'X') {
//					water.add(new Node(i, j));
//				}
//			}
//		}
//		
////		for(int i = 0; i < n; i++) {
////			for (int j = 0; j <m; j++) {
////				System.out.print(map[i][j] + " ");
////			}
////			System.out.println();
////		}
//
//		q.add(swan[0]);
//		visit[swan[0].x][swan[0].y] = true;
//
//		int ans = 0;
//		boolean meet = false;
//
//		while (true) {
//			Queue<Node> nq = new LinkedList<>();
//			while (!q.isEmpty()) {
//				Node now = q.poll();
//
//				if (now.x == swan[1].x && now.y == swan[1].y) {
//					meet = true;
//					break;
//				}
//
//				for (int i = 0; i < 4; i++) {
//					int nx = now.x + dx[i];
//					int ny = now.y + dx[i];
//
//					if (nx >= n || nx < 0 || ny >= m || ny < 0 || visit[nx][ny])
//						continue;
//
//					visit[nx][ny] = true;
//
//					if (map[nx][ny] == 'X') {
//						nq.add(new Node(nx, ny));
//						continue;
//					}
//
//					q.add(new Node(nx, ny));
//				}
//
//			}
//			
//			if (meet) {
//				break;
//			}
//			
//			q = nq;
//			int size = water.size();
//
//			for (int i = 0; i < size; i++) {
//				Node now = water.poll();
//
//				for (int d = 0; d < 4; d++) {
//					int nx = now.x + dx[d];
//					int ny = now.y + dy[d];
//
//					if (nx >= n || nx < 0 || ny >= m || ny < 0)
//						continue;
//
//					if (map[nx][ny] == 'X') {
//						map[nx][ny] = '.';
//						water.add(new Node(nx, ny));
//					}
//				}
//			}
//			ans++;
//		}
//		
//		System.out.println(ans);
//
//	}
//
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static Queue<Node> q;
	static Queue<Node> waterQ;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] map;
	static boolean[][] visited;
	static Node[] swan;
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		waterQ = new LinkedList<>();
		q = new LinkedList<>();
		swan = new Node[2];
		map = new char[R][C];
		visited = new boolean[R][C];
		
		// 데이터 입력
		int swanIdx = 0;
		for(int r = 0 ; r < R ; ++r) {
			char[] line = br.readLine().toCharArray();
			for(int c = 0 ; c < C ; ++c) {
				map[r][c] = line[c];
				if(map[r][c] == 'L') {
					swan[swanIdx++] = new Node(r, c);
				}
				if(map[r][c] != 'X') {
					waterQ.offer(new Node(r, c));
				}
			}
		}
		
		// 출발점이 되는 백조 
		q.offer(swan[0]);
		visited[swan[0].r][swan[0].c] = true;
		
		int day = 0;
		boolean meet = false;
		
		while(true) {
			Queue<Node> nextQ = new LinkedList<>();
			while(!q.isEmpty()) {
				Node now = q.poll();
				
				// 백조를 만날시 종료 
				if(now.r == swan[1].r && now.c == swan[1].c) {
					meet = true;
					break;
				}
				
				for(int d = 0 ; d < 4 ; ++d) {
					int nr = now.r + dir[d][0];
					int nc = now.c + dir[d][1];
					
					if(nr >= R || nr < 0 || nc >= C || nc < 0 || visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					
					// 물에 인접한 얼음으로 다음 날 백조가 탐색할 지역 
					if(map[nr][nc] == 'X') {
						nextQ.offer(new Node(nr, nc));
						continue;
					}
					// 현재 탐색 가능 지역
					q.offer(new Node(nr, nc));
				}
			}
			
			// 백조가 만났으면 종료 
			if(meet) break;
			// q를 다음날 탐색할 지역이 담긴 nextQ로 바꾼다. 
			q = nextQ;
			
			// 얼음을 녹인다.
			int size = waterQ.size();
			
			for(int i = 0 ; i < size ; ++i) {
				Node now = waterQ.poll();
				
				for(int d = 0 ; d < 4 ; ++d) {
					int nr = now.r + dir[d][0];
					int nc = now.c + dir[d][1];
					
					if(nr >= R || nr < 0 || nc >= C || nc < 0) continue;
					
					// 물에 인접한 얼음을 발견하면 녹이고 다시 큐에 넣는다. 
					if(map[nr][nc] == 'X') {
						map[nr][nc] = '.';
						waterQ.offer(new Node(nr, nc));
					}
				}
			}
			day++;
		}
		
		System.out.println(day);
	}
}
