import java.io.*;
import java.util.*;


public class Main {
    
    public static void main(String[] args) throws IOException {
    	// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = 0;
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            
            arr[L] = H;
            start = Math.min(L, start);
            end = Math.max(L, end);
        }

        Stack<Integer> height = new Stack<>();
        int temp = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if(arr[i] < temp)  { 
                height.push(i); 
            }
            else {
                while (!height.isEmpty()) {
                    int x = height.pop(); 
                    arr[x] = temp; 
                }
                temp = arr[i];
            }
        }
        height.clear();

        temp=arr[end];
        for(int i = end - 1; i >= start; i--){
            if(arr[i] < temp) height.push(i);
            else {
                while (!height.isEmpty()) {
                    int x = height.pop();
                    arr[x]=temp;
                }
                temp=arr[i];
            }
        }

        int result = 0;
        for (int i = start; i <= end; i++) {
            result += arr[i];
        }

        sb.append(result).append("\n");
        System.out.print(sb);
    }
}

