import java.io.*;
import java.util.*;

public class Main {
	
	static int N,files[];
	static long ans;
	public static void main(String[] args) throws Exception {
		
		Queue<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		files = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			files[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(files);
		
		
		int left = 0;
		int right = 0;
		
		while(left < N) {
			while(true) {
				if(right>=N-1) break;
				
				int Fi = files[left];
				int Fj = files[right+1];
				if(Fi < Fj*0.9) break;
				else right++;
			}

			ans += right-left;
			left++;
		}
		
		System.out.println(ans);
	}
}
