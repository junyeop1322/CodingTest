import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, arr[], res[];
	static boolean[] isSelec;
	static StringBuilder sb;
	static LinkedHashSet<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[M];
		isSelec = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		comb(0, 0);
		list.forEach(System.out::println);
	}

	static void comb(int cnt, int start) {
		sb = new StringBuilder();
		if (cnt == M) {
			for (int i : res) {
				sb.append(i).append(' ');
			}
			list.add(sb.toString());
			return;
		}
		
		for (int i = start; i < N; i++) {
			res[cnt] = arr[i];
			comb(cnt+1, i);
		}
		
	}
	
}
