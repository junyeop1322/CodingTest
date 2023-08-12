import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
				break;
			}
			
			if ((arr[0]*arr[0]) +(arr[1]*arr[1]) == (arr[2]*arr[2])) {
				sb.append("right\n");
			} else {
				sb.append("wrong\n");
			}
		}
		
		System.out.println(sb);
	}

}
