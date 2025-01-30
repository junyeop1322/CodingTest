import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] list = new int[n];
		list[0] = arr[0];
		int idx = 1;
		int tmp = 0;
		
		for (int i = 1; i < n; i++) {
			if (list[idx-1] < arr[i]) {
				list[idx++] = arr[i];
			} else if (list[0] > arr[i]) { 
				list[0] = arr[i];
			} else {
				tmp = Arrays.binarySearch(list, 0, idx, arr[i]);
				list[tmp < 0 ? (-tmp-1) : tmp] = arr[i];
			}
		}
		
		System.out.println(idx);
	}

}
