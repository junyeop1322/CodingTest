import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
        
		for(int i = 0; i < n; i++) list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list, Collections.reverseOrder());

        for(int i = 0; i < list.size(); i++) sb.append(list.get(i)+"\n");
    
        System.out.println(sb);
        
	}
}