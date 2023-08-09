import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if (num == 0) {
				if (!pQ.isEmpty()) {
					sb.append(pQ.poll()[1]).append("\n");
				} else {
					sb.append("0\n");
				}
			} else {
				pQ.offer(new int[] {Math.abs(num), num});
			}
		}
		
		System.out.println(sb);
	}

}
