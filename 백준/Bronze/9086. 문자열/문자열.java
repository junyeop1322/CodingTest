import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            String str = sc.next();

            char[] arr = str.toCharArray();

            System.out.printf("%s%s\n", arr[0], arr[arr.length - 1]);
        }
    }
}
