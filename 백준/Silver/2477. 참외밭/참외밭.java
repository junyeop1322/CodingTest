import java.util.*;
import java.io.*;

public class Main {
	static int K,maxWidth,maxHeight, indexWidth,indexHeight;
	static int[] length = new int[6];
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
        	
		maxHeight = Integer.MIN_VALUE;
		maxWidth = Integer.MIN_VALUE;
        	
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int direction = Integer.parseInt(st.nextToken());
			length[i] = Integer.parseInt(st.nextToken());
			if(direction==1 || direction == 2) {
				if(maxWidth < length[i]) {
					maxWidth = length[i];
					indexWidth = i;
				}
			}else {
				if(maxHeight < length[i]) {
					maxHeight = length[i];
					indexHeight = i;
				}
			}
		}
		int tempWidth = lengthCal(indexHeight);
		int tempHeight = lengthCal(indexWidth);
		
		int result = ((maxHeight * maxWidth) - (tempWidth * tempHeight)) * K;
		
        System.out.println(result);
	}
    	
	static int lengthCal(int index) {
		int result = 0;
		if(index==0)
			result = Math.abs(length[index+1] - length[5]);
		else if(index == 5)
			result = Math.abs(length[index-1] - length[0]);
		else
			result = Math.abs(length[index+1] - length[index-1]);
		
		return result;
	}

}