import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
		long sum = 0;
		
		int[][] treeInfo = new int[n][2]; 
		String[] input = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			treeInfo[i][0] = Integer.parseInt(input[i]);
		}
		
		input = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			treeInfo[i][1] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(treeInfo, new Comparator<int[]>(){
			@Override
			public int compare(int[] tree1, int[] tree2) {
				return tree1[1] - tree2[1];
			}
		});
		
		for(int day = 0; day < n; day++) {
			sum += treeInfo[day][0] + treeInfo[day][1]*day;
		}
		
        System.out.println(sum);
 	}
}