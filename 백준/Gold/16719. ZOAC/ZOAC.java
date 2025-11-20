import java.io.*;
import java.util.*;

public class Main {

    static class Data implements Comparable<Data> {
        char ch;
        int idx;
        public Data(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }

        @Override
        public int compareTo(Data o) {
            if (this.ch == o.ch) {
                return this.idx - o.idx;
            }
            return this.ch - o.ch;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        ArrayList<Data> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Data data = new Data(str.charAt(i), i);
            list.add(data);
        }

        Collections.sort(list);
        func(str, list);

        System.out.println(sb.toString());
    }

    private static void func(String str, ArrayList<Data> list) {
        boolean[] check = new boolean[str.length()];
        int startIdx = -1;

        while (!isCompleted(check)) {
            for (Data data: list) {
                if (!check[data.idx] && data.idx > startIdx) {
                    startIdx = data.idx;
                    check[data.idx] = true;
                    print(check, str);
                }
            }
            
            int i = list.size() - 1;
            for (; i >= 0; i--) {
                if (!check[i]) break;
            }

            boolean flag = false;
            for (;i >= 0; i--) {
                if (check[i]) {
                    flag = true;
                    startIdx = i;
                    break;
                }
            }
            if (!flag) startIdx = -1;
        }
    }

    private static boolean isCompleted(boolean[] check) {
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                return false;
            }
        }
        return true;
    }

    private static void print(boolean[] check, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (check[i]) {
                sb.append(str.charAt(i));
            }
        }
        sb.append("\n");
    }
}