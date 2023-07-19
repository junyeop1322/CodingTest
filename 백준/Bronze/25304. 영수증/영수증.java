import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int money = sc.nextInt();
        int N = sc.nextInt();

        int sum = 0;

        for(int n = 0; n < N; n++) {
            int aMoney = sc.nextInt();
            int aNum = sc.nextInt();

            sum += aMoney * aNum;
        }

        if (money == sum) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
