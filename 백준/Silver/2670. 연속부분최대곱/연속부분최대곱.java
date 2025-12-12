import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static double arr[];
    static double result = Double.MIN_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new double[n];
        for(int i=0; i<n; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        
        brute(0);
        
        System.out.printf("%.3f\n",result);
    }
    
    public static void brute(int start){
        if(start == n)
            return;
        
        double sum = 1.0;
        for(int i= start; i<n; i++){
            sum *= arr[i];
            result = Math.max(result, sum);
        }
        
        brute(start+1);
        
    }
}