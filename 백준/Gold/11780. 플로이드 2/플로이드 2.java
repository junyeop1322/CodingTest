import java.io.*;
import java.util.*;

public class Main {
	
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] arr= new int[n+1][n+1];
		int[][] brr= new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = INF;					
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[x][y] = Math.min(arr[x][y], cost);
			brr[x][y] = x;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
						brr[i][j] = brr[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] < INF) {
					System.out.print(arr[i][j] + " ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
		
		for (int i = 1; i <= n; i++) {
			int start = i;
			for (int end = 1; end <= n; end++) {
				if (start == end) {
					System.out.println(0);
				} else {
					Stack<Integer> stack = new Stack<>();
					int idx = brr[start][end];
					while(idx != 0) {
						stack.push(idx);
						idx = brr[start][idx];
					}
					
					if (stack.isEmpty()) {
						System.out.println(0);
					} else {
						System.out.print(stack.size() + 1 + " ");
						while(!stack.isEmpty()) {
							System.out.print(stack.peek() + " ");
							stack.pop();
						}
						System.out.println(end);
					}
					
				}
			}
		}
 		
	}

}
