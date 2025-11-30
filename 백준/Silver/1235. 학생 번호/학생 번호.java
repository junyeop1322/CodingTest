import java.io.*;
import java.util.*;

public class Main {
    static int N, l, result; 
    static Set<String> check;
    static String[] students;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        students = new String[N];
        result = 0;

        for(int i = 0; i < N; i++){
            students[i] = br.readLine();
        }
        l = students[0].length();

        for(int i = 1; i <= l; i++) {
            check = new HashSet<>();
            for (String student : students) {
                String tmp = student.substring(l - i, l);
                check.add(tmp);
            }
            if(check.size() == N){
                result = i;
                break;
            }
        }

        System.out.print(result);
    }
}