import java.io.*;
import java.util.*;
 
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
 
        List<String> li = new ArrayList<>();
        for(int i = 0; i < N; i++)
            li.add(br.readLine());
 
        Collections.sort(li, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length()-s2.length();
            }
        });
 
        int ans = N;
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(li.get(j).startsWith(li.get(i))){
                    ans--;
                    break;
                }
            }
        }
 
        System.out.println(ans);
    }
}