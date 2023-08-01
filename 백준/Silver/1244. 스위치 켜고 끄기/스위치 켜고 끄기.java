import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numS = sc.nextInt();
		int[] arr = new int[numS];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int numStudent = sc.nextInt();
		
		for (int i = 0; i < numStudent; i++) {
			int sex = sc.nextInt();
			int swi = sc.nextInt();
			
			if (sex == 1) { // 남자일 때
				for (int j = 0; j < arr.length; j++) { 
					if((j + 1) % swi == 0) { // 배열의 자리가 숫자의 배수라면
						if (arr[j] == 1) {
							arr[j] = 0;
						} else {
							arr[j] = 1;
						}
					}
				}
			} else {
				if (arr[swi -1] == 1) {
					arr[swi-1] = 0;
				} else {
					arr[swi-1] = 1;
				}
				for (int j = 1; j <= arr.length / 2; j++) {
					if (swi -1 - j < 0 || swi - 1 + j >= arr.length) {
						break;
					}
					
					if (arr[swi-1 -j] == arr[swi-1 + j]) {
						if (arr[swi-1 -j] == 0) {
							arr[swi-1 -j] = 1;
							arr[swi-1 +j] = 1;
						} else {
							arr[swi-1 - j] = 0;
							arr[swi-1 + j] = 0;
						}
					} else {
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if ((i+1) % 20 == 0) {
				System.out.println();
			}
		}
		sc.close();
	}

}
