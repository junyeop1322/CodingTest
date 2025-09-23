import java.io.*;
import java.util.*;
 
public class Main {
    private static int N, T, M;
    private static int answer = 0;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int mid = (N - 1) / 2;
		System.out.println(arr[ mid ] );
	}
    
}