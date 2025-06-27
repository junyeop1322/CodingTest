import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
 
		int[][] arr = new int[n][2];
 
		String[] brr;
		for(int i = 0; i < n; i++) {
			brr = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(brr[0]);
			arr[i][1] = Integer.parseInt(brr[1]);
		}
		
				
		for(int i = 0; i < n; i++) {
			int cnt = 1;
			
			for(int j = 0; j < n; j++) {
				if(i == j) continue;
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					cnt++;
				}
			}
 
			System.out.print(cnt + " ");
		}
 
	}
}