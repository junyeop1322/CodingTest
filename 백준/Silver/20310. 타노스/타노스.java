import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String words = br.readLine();
        int countZero = 0;
        int countOne = 0;

        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) == '0') {
                countZero++;
            } else {
                countOne++;
            }
        }
        countZero/=2;
        countOne/=2;
        
        int i = 0;
        while (countOne != 0) {
            if (words.charAt(i) == '1') {
                words = words.substring(0, i) + words.substring(i + 1);
                countOne--;
                i = -1;
            }
            i++;
        }

        int j = words.length() - 1;
        while (countZero != 0) {
            if (words.charAt(j) == '0') {
                words = words.substring(0, j) + words.substring(j + 1);
                countZero--;
                j = words.length();
            }
            j--;
        }
        System.out.println(words);
    }
}