import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isCheck = new boolean[26];

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < n; t++) {
            String option = br.readLine();
            String str = findRepresentativeKey(option, isCheck);

            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

    static String findRepresentativeKey(String option, boolean[] isCheck) {
        String[] words = option.split(" ");
        for (int wordIdx = 0; wordIdx < words.length; wordIdx++) {

            char alphabet = words[wordIdx].charAt(0);

            if (alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char)('a' + (alphabet - 'A'));
            }
            int num = alphabet - 'a';

            if (!isCheck[num]) {
                isCheck[num] = true;
                String key = makeKey(words, wordIdx);
                return key;
            }
        }

        for (int i = 1; i < option.length(); i++) {
            if (option.charAt(i) == ' ') {
                i += 1;
                continue;
            }

            char alphabet = option.charAt(i);

            if (alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char)('a' + (alphabet - 'A'));
            }
            int num = alphabet - 'a';

            if (!isCheck[num]) {
                isCheck[num] = true;
                String key = makeKey(option, i);
                return key;
            }
        }

        return option;
    }

    static String makeKey(String[] words, int wordIdx) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == wordIdx) {
                sb.append("[").append(word.charAt(0)).append("]");
                sb.append(word.substring(1)).append(" ");
            }
            else {
                sb.append(words[i]).append(" ");
            }
        }
        return sb.toString();
    }

    static String makeKey(String option, int idx) {
        StringBuilder sb = new StringBuilder();
        sb.append(option, 0, idx);
        sb.append("[").append(option.charAt(idx)).append("]");
        sb.append(option.substring(idx+1));

        return sb.toString();
    }
}