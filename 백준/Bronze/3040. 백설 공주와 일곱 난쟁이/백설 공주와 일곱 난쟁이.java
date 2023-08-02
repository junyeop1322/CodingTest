import java.util.Scanner;

public class Main {

	static int[] arr;
	static int[] res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		res = new int[7];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		dwarf(0, 0);
		
	}
	
	static void dwarf(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < res.length; i++) {
				sum += res[i];
			}
			if (sum == 100) {
				for (int i = 0; i < res.length; i++) {
					System.out.println(res[i]);
				}
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			res[cnt] = arr[i];
			
			dwarf(cnt+1, i +1);
		}
	}

}
