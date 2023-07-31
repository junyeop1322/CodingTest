import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        long ans = fact(n);

        System.out.println(ans);
    }

    static long fact(long n) {
        if(n < 2) {
            return 1;
        } else {
            return  n * fact(n -1);
        }
    }
}
