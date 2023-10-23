import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] phone_number = new String[N]; // 전화번호 목록.
 
            for (int i = 0; i < N; i++) {
                phone_number[i] = br.readLine();
            }
            Arrays.sort(phone_number); // 오름차순으로 정렬.
 
            if (isConsistent(N, phone_number)) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
 
        bw.flush();
        bw.close();
        br.close();
    }
 
    public static boolean isConsistent(int N, String[] phone_number) {

        for (int i = 0; i < N - 1; i++) {
            if (phone_number[i + 1].startsWith(phone_number[i])) {
                return false;
            }
        }
 
        return true;
    }
 
}