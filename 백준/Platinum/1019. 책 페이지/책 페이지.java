import java.io.*;

public class Main {
	
	static int[] arr;
	static int start, end, digit;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		end = Integer.parseInt(br.readLine());
		start = 1;
		digit = 1;

		arr = new int[10];
		
		while(start <= end) {
			while(start % 10 != 0 && start <= end) {
				func(start, digit);
				start++;
			}
			
			while(end % 10 != 9 && start <= end) {
				func(end, digit);
				end--;
			}
			
			if (start > end) break;
			
			start /= 10;
			end /= 10;
			
			for (int i = 0; i < 10; i++) {
				arr[i] += (end - start + 1) * digit;
			}
			
			digit *= 10;
		}
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
	}
	
	static void func(int num, int digit) {
		while(num > 0) {
			arr[num % 10] += digit;
			num /= 10;
		}
	}

}
