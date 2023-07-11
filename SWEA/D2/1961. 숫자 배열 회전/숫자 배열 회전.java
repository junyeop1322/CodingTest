import java.io.*;
import java.util.*;
 
public class Solution {
    static int[][] arr;
    static int N;
    
    public static void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int T = 0; T < tc; T++) {    
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];    
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[][] rotation_90 = Rotation(arr);    
            int[][] rotation_180 = Rotation(rotation_90);    
            int[][] rotation_270 = Rotation(rotation_180);    
            System.out.println("#" + (T+1));
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    System.out.print(rotation_90[i][j]);    
                }
                System.out.print(" ");
                
                for(int j = 0; j < N; j++) {
                    System.out.print(rotation_180[i][j]);    
                }
                System.out.print(" ");
                
                for(int j = 0; j < N; j++) {
                    System.out.print(rotation_270[i][j]);   
                }
                System.out.println("");
            }
        }
    }
    

    public static int[][] Rotation(int[][] arr) {
        int[][] temp_arr = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                temp_arr[i][j] = arr[N - 1 - j][i];
            }
        }
        
        return temp_arr;
    }
    
    public static void main(String[] args) throws Exception {
        Solution.run();
    }
}