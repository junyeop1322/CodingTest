import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		String arr[] = new String[n];
		String temp[] = new String[n];

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			arr[i] = str;
			temp[i] = str;
		}

		Arrays.sort(temp);

		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (!arr[i].equals(temp[i])) {
				flag = true;
				break;
			}
		}

		if (!flag)
			System.out.println("INCREASING");
		else {
			Arrays.sort(temp, Collections.reverseOrder());
			flag = false;

			for (int i = 0; i < n; i++) {
				if (!arr[i].equals(temp[i])) {
					flag = true;
					break;
				}
			}

			if(!flag)
				System.out.println("DECREASING");
			else
				System.out.println("NEITHER");
		}
	}
}