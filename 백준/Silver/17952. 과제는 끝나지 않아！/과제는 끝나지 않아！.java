import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Stack<int[]> stack = new Stack<>(); // 후입선출을 위해 stack 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // bufferedReader를 통해 입력값 받기
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 총 몇분인지 받기 위해 n을 선언
		int ans = 0; // 정답을 담을 ans 변수 선언

		for (int i = 0; i < n; i++) { // 총 n번 동안 진행
			st = new StringTokenizer(br.readLine());
			int work = Integer.parseInt(st.nextToken()); // 일이 있는지 없는지를 위해 work변수를 선언

			if (work == 1) { // work가 1이라면, 즉 일을 받았다면
				int point = Integer.parseInt(st.nextToken()); // 일에 대한 점수 받기
				int min = Integer.parseInt(st.nextToken()); // 일을 끝낼 시간 받기

				if (min == 1) { // 시간이 1분이라면, 즉 한 차례만에 끝낼 수 있다면
					ans += point; // ans 변수에 point 추가
				} else { // 그렇지 않다면, 즉 min이 2이상이라면
					int[] a = { point, min }; // 배열을 선언하고 배열에 point와 min을 넣어
					stack.push(a); // stack에 push
				}
			}
			if (work == 0) { // work가 0이라면, 즉 일이 없다면
				
				if (!stack.isEmpty()) { // 만약 stack에 무언가가 있다면
					int[] b = stack.pop(); // 배열 b를 stack에서 pop받음
					int nextMin = b[1]; // 배열 b의 min을 nextBMin로 선언
					
					nextMin -= 1; // work가 0이기 때문에 stack의 맨 위에 있는 시간이 1 줄어야 함
					// 그래서 nextMin의 시간을 1감소
					
					if (nextMin == 1) { // 만약 시간을 감소해서 nextMin이 1이 됐다면
						ans += b[0]; // 정답에 배열 b의 point 값을 넣음
					} else { // 그렇지 않다면, 즉 아직까지 nextMin의 값이 2 이상이라면
						int[] c = {b[0], nextMin}; // 다시 stack에 넣어줌
						stack.push(c);
					}
					
				}
			}
		}
		
		System.out.println(ans);
	}

}
