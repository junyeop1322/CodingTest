import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] depth;
    static int[][] parent;
    static int height = 0, N;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= N; i *= 2)
            height++;
        
        parent = new int[N+1][height];
        depth = new int[N+1];
        
        for(int i = 0; i <= N; i++)
            tree.add(new ArrayList<>());
            
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        setTree(1, 1, 0);
        parentInit();
        
        int M = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            System.out.println(LCA(a, b));
        }
    }
    
    static void setTree(int c, int d, int p){
        depth[c] = d;
        parent[c][0] = p;
        
        for(int next : tree.get(c)){
            if(next == p)
                continue;
            setTree(next, d+1, c);
        }
    }
    
    static void parentInit() {
        for(int i = 1; i < height; i++) {
            for(int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }
    
    static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];
        
        if (ah < bh) {
            int temp = b;
            b = a;
            a = temp;
        }
        
        for (int i = height-1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b])
                a = parent[a][i];
        }
        
        if(a == b)
            return a;
        
        for (int i = height-1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];	
    }
}