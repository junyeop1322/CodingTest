import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		int num1 = (str1.charAt(2)- '0')*100 + (str1.charAt(1)-'0')*10 + (str1.charAt(0)-'0');
		int num2 = (str2.charAt(2)- '0')*100 + (str2.charAt(1)-'0')*10 + (str2.charAt(0)-'0');
		int max = Math.max(num1, num2);
		
		System.out.println(max);
	}

}
