import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] cal = {31 ,28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] seven = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		int date = 0;
		
		if (month > 1) {
			for (int i = 0; i <= month-2; i++) {
				date += cal[i];
			}
		}
		
		date += day;
		
		System.out.println(seven[date%7]);
		
	}

}
