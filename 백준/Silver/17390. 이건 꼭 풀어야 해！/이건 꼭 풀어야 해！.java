import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int arr[] = new int[A+1];
        int temp[] = new int[A+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= A ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        for (int i = 1; i <= A ; i++) {
            temp[i] = temp[i-1] + arr[i];
        }

        for (int i = 0; i < B ; i++) {
            st = new StringTokenizer(br.readLine());


            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());


            sb.append(temp[R] - temp[L-1]).append("\n");
        }
        System.out.println(sb.toString());


    }
}