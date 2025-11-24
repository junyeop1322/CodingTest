import java.io.*;
import java.util.*;

public class Main {
    
    static char[][] table;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        table = new char[R][C];
      
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            
            for (int j = 0; j < C; j++) {
                table[i][j] = str.charAt(j);
            }
        }
      
        int result = search(R, C);
      
        System.out.println(String.valueOf(result));
    }
    
    static int search(int R, int C){
        int start = 0;
        int end = R - 1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if (check(mid, R, C)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return start;
    }
    
    static boolean check (int mid, int R, int C) {
        HashSet<String> set = new HashSet<>();
    
        for (int i = 0; i < C; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = mid+1; j < R; j++) {
                str.append(table[j][i]);
            }
            if (set.contains(str.toString())) {
                return false;
            }
            set.add(str.toString());
        }
        
        return true;
    }
}