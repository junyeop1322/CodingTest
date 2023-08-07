import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> sta = new Stack<>(); // 스택을 사용 -> 배열을 이용해 0번째에는 숫자, 1번째에는 탑의 높이를 받음
		int n = Integer.parseInt(st.nextToken()); // 배열의 개수 n을 받음

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int v = Integer.parseInt(st.nextToken()); // 탑의 높이를 받음
			while (!sta.isEmpty()) { // 스택이 안 비어 있을 때
				if (v <= sta.peek()[1]) { // 스택의 제일 앞의 탑의 높이가 새로 들어온 탑의 높이보다 높다면 
					System.out.print(sta.peek()[0] + " "); // 스택의 제일 앞의 탑의 번호를 출력
					break;
				}
				sta.pop(); // 스택의 제일 앞의 탑의 높이가 높지 않으면 맨 앞을 pop해서 버림
			}
			if (sta.isEmpty()) { // 만약 스택에 아무것도 안 들어 있다면
				System.out.print(0 + " "); // 0을 출력
			}

			sta.push(new int[] { i, v }); // 이 과정이 끝나면 스택에 push해줌
		}

	}

}
