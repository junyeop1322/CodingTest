import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
 
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        
        while (i < N) {
            if (arr[i] - arr[j] < M) {
                i++;
                continue;
            }
 
            if (arr[i] - arr[j] == M) {
                ans = M;
                break;
            }
 
            ans = Math.min(ans, arr[i] - arr[j]);
            j++;
        }
 
        System.out.println(ans);
    }
 
}