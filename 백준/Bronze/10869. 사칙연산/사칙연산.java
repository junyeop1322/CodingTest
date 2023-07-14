import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int a1 = A + B;
		int a2 = A - B;
		int a3 = A * B;
		int a4 = A / B;
		int a5 = A % B;
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a5);

	}
}