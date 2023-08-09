import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] res;
	static boolean[] isSelec;
	static LinkedHashSet<String> list;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[M];
		isSelec = new boolean[N];
		list = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		perm(0);

		list.forEach(System.out::println);
	}

	static void perm(int cnt) {
		if (cnt == M) {
			sb = new StringBuilder();
			for (int i : res) {
				sb.append(i).append(' ');
			}
			
			list.add(sb.toString());

			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelec[i]) {
				continue;
			}
			isSelec[i] = true;
			res[cnt] = arr[i];

			perm(cnt + 1);
			isSelec[i] = false;

		}
	}
}
