import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()) * 2;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = arr[i] + arr[n - i - 1];
            if (min > sum)
                min = sum;
        }

        System.out.println(String.valueOf(min));
    }

}