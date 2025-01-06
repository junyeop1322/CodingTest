import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			
			sb.append(isPalin(str) + "\n");
		}

		System.out.println(sb.toString());
	}
	
	static int isPalin(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		
		if (str.equals(sb.reverse().toString())) {
			return 0;
		} else {
			int left = 0;
			int right = str.length()-1;
			
			while (left < right) {
				if (str.charAt(left) != str.charAt(right)) {
					StringBuilder sbLeft = new StringBuilder(str).deleteCharAt(left);
					StringBuilder sbRight = new StringBuilder(str).deleteCharAt(right);
					
					if (sbLeft.toString().equals(sbLeft.reverse().toString()) || sbRight.toString().equals(sbRight.reverse().toString())) {
						return 1;
					}
					break;
				}
				
				left++;
				right--;
			}
		}
		
		return 2;
	}

}
