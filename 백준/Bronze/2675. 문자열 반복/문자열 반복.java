import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int num = sc.nextInt();
            String str = sc.next();

            char[] arr = str.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < num; j++) {
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
        }
    }
}
