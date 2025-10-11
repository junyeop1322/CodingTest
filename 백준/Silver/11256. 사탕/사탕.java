import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        final int NUMBER_OF_TESTCASE = Integer.parseInt(br.readLine());
        
        for (int k = 0; k < NUMBER_OF_TESTCASE; k++) {
            st = new StringTokenizer(br.readLine());
            int NUMBER_OF_CANDY = Integer.parseInt(st.nextToken());
            int NUMBER_OF_BOX = Integer.parseInt(st.nextToken());
            int boxSize[] = new int [NUMBER_OF_BOX];
            
            for (int i = 0; i < NUMBER_OF_BOX; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                boxSize[i] = num1 * num2;
            }

            Arrays.sort(boxSize);
            int answer = 0;
            
            for(int i = NUMBER_OF_BOX-1; i > -1; i--) {
                answer++;
                NUMBER_OF_CANDY-=boxSize[i];
                
                if(NUMBER_OF_CANDY < 1) {
                    break;
                }
            }

            sb.append(answer);
            sb.append("\n"); 
        }
        
        System.out.println(sb.toString());
    }
    
}