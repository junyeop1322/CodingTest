import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		int cnt = 0;
		int[] exit = new int[2];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] =  s.charAt(j);
				if(board[i][j] == 'X') {
					board[i][j] = Integer.toString(cnt++).charAt(0);
				} else if(board[i][j] == 'S') {
					board[i][j] = '.';
					q.add(new int[] {i,j,0});
				} else if(board[i][j] == 'E') {
					exit = new int[] {i,j};
				}
			}			
		}
		
		BFS(board,cnt,q,exit);
		
		
	}
	public static void BFS(char[][] board, int cnt, Queue<int[]> q, int[] exit) {
		boolean[][][] v = new boolean[N][M][(int)Math.pow(2, cnt)];
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size>=0) {
				int[] now = q.poll();
				if (now[2] == ((int)Math.pow(2, cnt)-1) && now[0] == exit[0] && now[1] == exit[1]) {
					System.out.println(time);
					return;
				}
				for (int d = 0; d < 4; d++) {
					int nx = now[0]+dx[d];
					int ny = now[1]+dy[d];
					if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] != '#' && !v[nx][ny][now[2]]) {
						v[nx][ny][now[2]] = true;
						if (board[nx][ny] == '.' || board[nx][ny] =='E') {
							q.add(new int[] {nx,ny,now[2]});
						} else {
							int keyNum = board[nx][ny] - '0';
							if ((now[2]&(1<<keyNum)) == 0){
								keyNum = (now[2] | (1<<keyNum));
								q.add(new int[] {nx,ny,keyNum});
							} else {
								q.add(new int[] {nx,ny,now[2]});
							}
							
						}
					}
				}
			}
			time++;
		}
		
		
	}
	
	
}