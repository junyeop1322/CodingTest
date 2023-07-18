import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        String num2 = sc.next();

        for(int i = 2; i >= 0; i--) {
            System.out.println(num1 * (int)(num2.charAt(i) - '0'));
        }
        System.out.println(num1 * Integer.parseInt(num2));
    }
}
