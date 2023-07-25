import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			if (binarySearch(arr, sc.nextInt()) == 0) {
				sb.append(0 + "\n");
			}
			else {
				sb.append(1 + "\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	public static int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			if (target > arr[mid]) {
				low = mid + 1;
			}
			else if (target < arr[mid]) {
				high = mid - 1;
			}
			else {
				return 1;
			}
		}
		return 0;
	}

}


// 1트 시간초과 => 어차피  for 문 돌리는 것에서 정답이 틀렸었음
// 2트 시간초과 => 정답은 나오는데 시간 초과 문제 해결 필요
// 3트 시간초과 => ArrayList로 변환해봤는데 큰 효과 없었음
// 4트 틀렸음 => 이제 시간 초과 문제는 해결 => binarySerach 함수 만들어서 해결