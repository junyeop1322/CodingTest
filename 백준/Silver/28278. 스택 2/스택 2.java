import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		Stack<Integer> stackList = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			int order = sc.nextInt();
			int num = 0;
			
			switch(order) {
			case 1:
				num = sc.nextInt();
				stackList.push(num);
				break;
			case 2:
				if(stackList.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stackList.pop()).append("\n");
				}
				break;
			case 3:
				sb.append(stackList.size()).append("\n");
				break;
			case 4:
				if (stackList.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case 5:
				if(stackList.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stackList.peek()).append("\n");
				}
				break;
			}
		}
		
		System.out.println(sb);
	}

}
