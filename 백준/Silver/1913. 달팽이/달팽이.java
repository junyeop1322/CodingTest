import java.io.*;
 
public class Main {
	static int[][] arr;
	static int n;
	static int x;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        x = Integer.parseInt(br.readLine());
        int resultRow = 0;
        int resultCol = 0;
        arr = new int[n][n];
        
        StringBuilder sb = new StringBuilder();

        create();
 
        for(int i = 0 ; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		sb.append(arr[i][j] + " ");
        		if(arr[i][j] == x) {
        			resultRow = i + 1;
        			resultCol = j + 1;
        		}
        	}
        	sb.append("\n");
        }
        
        sb.append(resultRow + " " + resultCol);
        System.out.println(sb);
        
        br.close();
    }
    
    public static void create() {
    	int curRow = n / 2;
    	int curCol = n / 2;
    	
    	int next = 0;
    	int count = 0;
    	
    	int max = 1;
    	int ls =0;
    	
    	for(int i = 1; i <= n * n; i++) {
    		arr[curRow][curCol] = i;
    		
    		curRow += dx[next % 4];
    		curCol += dy[next % 4];
    		count++;
    			
    		if(count == max) {
    			next++;
    			count = 0;
    			ls++;
    		}
    		
    		if(ls == 2) {
    			max++;
    			ls = 0;
    		}
    	}
    }
}