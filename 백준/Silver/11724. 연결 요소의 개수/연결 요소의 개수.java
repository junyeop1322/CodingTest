import java.util.*;
import java.io.*;

public class Main {
	static int arr[][];
	static boolean node[];
	static int N, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		node = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		cnt = 0;
		for(int i = 1; i <= N; i++) {	
			if(node[i] == false) {
				dfs(i);				
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int value) {
		
		if(node[value] == true) {
			return;
		}

		node[value] = true;
		for(int i = 1; i <= N; i++) {
			if(arr[value][i] == 1) {
				dfs(i);
			}
		}
	}

}