import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				list.add(arr[i] + arr[j]);
			}
		}
		
		Arrays.sort(arr);
		Collections.sort(list);
		
		for (int i = n-1; i >= 0; i--) {
			for (int j = n-1; j >= 0; j--) {
				int num = arr[i] - arr[j];
				
				if (Collections.binarySearch(list, num) >= 0) {
					System.out.println(arr[i]);
					return;
				}
			}
		}

	}

}
