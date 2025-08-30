import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {

			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int[] result = Arrays.stream(arr).distinct().toArray();
		sb.append(Arrays.toString(result));
		System.out.print(sb.toString().replace("[", "").replace("]", "").replace(", ", " "));
	}
}