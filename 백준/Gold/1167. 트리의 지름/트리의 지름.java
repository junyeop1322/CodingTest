import java.io.*;
import java.util.*;

public class Main {
    static int V;
	static ArrayList<Node> edges[];
	static boolean visit[];
	static int candidate;
	static int ans;
    
	static class Node{
		int to;
		int cost; 
		public Node(int to, int cost) {
			this.to=to;
			this.cost=cost;
		}
	}

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		edges = new ArrayList[V+1];
		visit = new boolean[V+1];
		
		for(int i = 0; i <= V; i++) {
			edges[i]= new ArrayList<Node>();
		}
        
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex = Integer.parseInt(st.nextToken());
			while(true) {
				int next = Integer.parseInt(st.nextToken());
				if(next == -1)
					 break;
                
				int cost = Integer.parseInt(st.nextToken());
				edges[vertex].add(new Node(next,cost));
			}
		}
		
		dfs(1,0);
		
		visit = new boolean[V+1];
		dfs(candidate, 0);
		
		System.out.println(ans);
	}
	
	static public void dfs(int v, int len) {
		if(len > ans) {
			ans = len;
			candidate = v;
		}
        
		visit[v]=true;
		for(int i = 0; i < edges[v].size(); i++) {
			Node next = edges[v].get(i);
			if(visit[next.to] == false) {
				dfs(next.to, len+next.cost);
			}
		}
	}
	
}