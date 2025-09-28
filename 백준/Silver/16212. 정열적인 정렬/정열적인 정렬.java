import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int n = Integer.parseInt(br.readLine());
	    int [] arr = new int[n];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++){
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arr);
	    
	    for(int num:arr){
	        sb.append(num).append(" ");
	    }
	    
	    System.out.print(sb);
	}
}