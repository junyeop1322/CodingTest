import java.io.*;

public class Main{
    
    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int count = 0;
        
        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if (temp == 'X') {
                count++;
            } else {
                if(!check(count))
                    break;
                answer.append(".");
                count = 0;
            }
        }
        
        if(!answer.equals("-1") && str.charAt(str.length()-1) == 'X')
            check(count);
        
        System.out.println(answer.toString());
    }
    
    static boolean check(int count){
        String A = "AAAA";
        String B = "BB";
        if(count % 4 == 0){
            for(int j = 0; j < count/4; j++) {
                answer.append(A);
            }
        } else if(count % 4 == 2){
            for (int j = 0; j < count / 4; j++) {
                answer.append(A);
            }
            
            answer.append(B);
        } else if(count == 2) {
            answer.append(B);
        } else {
            answer = new StringBuilder("-1");
            return false;
        }
        return true;
    }
}