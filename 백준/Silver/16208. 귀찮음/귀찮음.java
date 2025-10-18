import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
 
        long[] arr = new long[N];
        long total = 0;
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            total += arr[i];
        }
 
        long ans = 0;
 
        for (int i = 0; i < N; i++) {
            long temp = arr[i];
            total -= temp;
            ans += temp * total;
        }
 
        System.out.println(ans);
    }
 
}