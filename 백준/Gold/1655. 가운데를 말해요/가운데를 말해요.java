import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> Max = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> Min = new PriorityQueue<>();
		
		
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(Max.size() == Min.size()) {
				Max.add(num);
			} else {
				Min.add(num);
			}
			
			if (!Min.isEmpty() && !Max.isEmpty()) {
				if (Min.peek() < Max.peek()) {
					int temp = Min.poll();
					Min.add(Max.poll());
					Max.add(temp);
				}
			}
			
			sb.append(Max.peek() + "\n");
		}
		
		System.out.println(sb);
	}

}
