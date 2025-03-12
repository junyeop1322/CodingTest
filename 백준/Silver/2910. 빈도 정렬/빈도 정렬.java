import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			list1.add(Integer.parseInt(st.nextToken()));
			list2.add(list1.get(i));
			
			map.put(list1.get(i), map.getOrDefault(list1.get(i), 0) + 1);
		}
		
		Collections.sort(list1, (o1, o2) -> {
			if (map.get(o1) == map.get(o2)) {
				return list2.indexOf(o1) - list2.indexOf(o2);
			}
			
			return Integer.compare(map.get(o2), map.get(o1));
		});
		
		for (int i = 0; i < n; i++) {
			System.out.print(list1.get(i) + " ");
		}

	}

}
