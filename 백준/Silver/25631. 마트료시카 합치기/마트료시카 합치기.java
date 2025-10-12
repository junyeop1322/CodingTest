import java.io.*;
import java.util.*;

public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    static StringTokenizer st;
	static int N, tmp;
	static Map<Integer, Integer> map;
	static PriorityQueue<Integer> pq;
	
    public static void main(String[] args) throws IOException {
		map = new HashMap<>();
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
        
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			if (map.get(tmp) == null) {
				map.put(tmp, 1);
			}
			else {
				map.put(tmp, map.get(tmp)+1);
			}
		}
		pq = new PriorityQueue<Integer>(new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2)-map.get(o1);
			}
		});
		for(int key : map.keySet()) {
			pq.offer(key);
		}
        
		System.out.println(String.valueOf(map.get(pq.poll())));
	}
}