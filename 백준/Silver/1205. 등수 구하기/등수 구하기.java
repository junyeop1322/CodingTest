import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Taesu = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int ans = 1;
		ArrayList<Integer> list = new ArrayList<>();
		
		if (N!=0) { 
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list);
			Collections.reverse(list);
			
			int[] rank = new int[P];
			int[] index = new int[P];
			for (int i=0; i<P; i++) {
				if (list.size()>i) {
					rank[i] = list.get(i);
					if (i!=0) {
						if (rank[i]==rank[i-1]) index[i] = index[i-1];
						else index[i] = i+1;
					}
					else index[i] = 1;
				}
				else rank[i] = -1;
			}
            
			for (int i=0; i<P; i++) {
				if (rank[i] < Taesu) {
					if (i!=0 && rank[i-1] == Taesu) ans = index[i-1]; 
					else {
						if (index[i]==0) ans = i+1;
						else ans = index[i];
					}
					break;
				}
				
				if (i==P-1) ans = -1;
			}
		}
		
		System.out.println(ans);
	}
}