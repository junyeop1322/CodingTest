
//import java.util.Scanner;
import java.io.*;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(hanoi1(n));
		hanoi2(n, 1, 2, 3);
		System.out.println(sb.toString());
		
		br.close();
	}

	static int hanoi1(int n) {
		if (n < 2) {
			return 1;
		} else {
			return (hanoi1(n-1) * 2) + 1;
		}
	}
	
	static void hanoi2(int n, int start, int by, int to) {
		if (n < 2) {
			sb.append(start + " " + to + "\n");
		} else {
			hanoi2(n - 1, start, to, by);
			sb.append(start + " " + to + "\n");
			hanoi2(n - 1, by, start, to);
		}
	}
	
}
