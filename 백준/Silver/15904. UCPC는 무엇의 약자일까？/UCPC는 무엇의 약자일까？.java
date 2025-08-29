import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int idx = 0;
		boolean flag = true;
		char[] arr = { 'U', 'C', 'P', 'C' };
		int i = 0;

		while (i < 4) {

			int nIdx = str.indexOf(arr[i++], idx);

			if (nIdx == -1) {
				flag = false;
				break;
			}

			idx = nIdx + 1;
		}

		if (flag)
			System.out.println("I love UCPC\n");
		else
			System.out.println("I hate UCPC\n");
	}

}