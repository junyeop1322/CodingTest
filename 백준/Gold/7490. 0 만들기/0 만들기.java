import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toList;

public class Main {

	static int n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			comb(1, 1, "1");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void comb(int num, int len, String str) {
		
		if (len == n) {
			if (calc(str) == 0) {
				sb.append(str).append("\n");
			}
			return;
		}
		
		comb(num+1, len+1, str + " " + (num+1));
		comb(num+1, len+1, str + "+" + (num+1));
		comb(num+1, len+1, str + "-" + (num+1));	
	}
	
	static int calc(String str) {
		str = str.replaceAll(" " , "");
		Iterator<Integer> it = Arrays.stream(str.split("[+,-]"))
				.map(Integer::parseInt)
				.collect(toList()).iterator();
		int num = it.next();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+') {
				num += it.next();
			} else if (str.charAt(i) == '-') {
				num -= it.next();
			}
		}
		
		return num;
	}


}
