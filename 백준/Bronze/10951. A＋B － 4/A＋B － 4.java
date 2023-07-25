import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        while(sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            ans = a + b;

            System.out.println(ans);
        }
    }
}
