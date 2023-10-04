import java.io.*;
import java.util.*;

public class Main {

	static int cnt = 0;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		list = new ArrayList<>();
		
		KMP(origin, pattern);
		
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.println(list.get(i));
		}
	}

	static void KMP(String org, String ptn) {
		int[] pi = getPi(ptn);
		int j = 0;
		
		for (int i = 0; i < org.length(); i++) {
			while(j > 0 && org.charAt(i) != ptn.charAt(j)) {
				j = pi[j-1];
			}
			
			if (org.charAt(i) == ptn.charAt(j)) {
				if (j == ptn.length() - 1) {
					++cnt;
					list.add(i-j+1);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		
	}
	
	static int[] getPi(String ptn) {
		int[] pi = new int[ptn.length()];
		
		int j = 0;
		for (int i = 1; i < ptn.length(); i++) {
			while(j > 0 && ptn.charAt(i) != ptn.charAt(j)) {
				j = pi[j-1];
			}
			
			if (ptn.charAt(i) == ptn.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
}
