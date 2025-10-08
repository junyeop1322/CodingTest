import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int weightA = Integer.parseInt(br.readLine());
        Integer weightK[] = new Integer[N];

        for (int i = 0; i < N; i++) {
            weightK[i] = Integer.parseInt(br.readLine());
        };

        Arrays.sort(weightK, Comparator.reverseOrder());

        int res = 0;
        int price = 0;
        int result = weightA/A;
        int cal = weightA;
        for (int i = 0; i < N ; i++) {
            price = A + (B * (i+1)) ;
            cal += weightK[i];

             res = cal / price;
            if(result > res){break;}
             if(result < res){
                result = cal / price;
            }
        }
        System.out.println(result);
    }
}