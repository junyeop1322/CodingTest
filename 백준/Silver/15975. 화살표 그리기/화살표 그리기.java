import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N= fr.nextInt();

        ArrayList<int[]> Info = new ArrayList<>();
        int colorSize[] = new int[N+1];
        for(int i =0 ;i < N ;i++){
            int x = fr.nextInt();
            int color = fr.nextInt();
            Info.add(new int[]{x,color});
            colorSize[color]++;
        }
        Collections.sort(Info, (a,b)->a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);//색깔별, x좌표순 별 정렬
        long ans = 0;

        for(int i = 0 ;i < Info.size() ;i++){
            if (colorSize[Info.get(i)[1]] > 0) {
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                int ldx = i-1;
                int rdx = i+1;
                if(ldx >= 0 && Info.get(ldx)[1] == Info.get(i)[1]){
                    left = Info.get(i)[0]-Info.get(ldx)[0];
                }
                if(rdx < Info.size() && Info.get(rdx)[1] == Info.get(i)[1]){
                    right = Info.get(rdx)[0] - Info.get(i)[0];
                }
                int v = Math.min(left,right);
                ans += v != Integer.MAX_VALUE ? v : 0;
            }
        }
        System.out.println(ans);

    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}