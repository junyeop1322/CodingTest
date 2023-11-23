import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bf.readLine();
        Stack<Character> stack = new Stack<>();
 
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') { // 열린 괄호면 스택에 추가.
                stack.push('(');
                continue;
            }
            if (input.charAt(i) == ')') { // 닫힌 괄호일 경우,
                stack.pop();
 
                if (input.charAt(i - 1) == '(') { // 그 전 괄호가 열린 괄호면 레이저를 의미.
                    result += stack.size(); 
                } else {
                    result++;
                }
            }
        }
 
        bw.write(result + "\n");
        bw.flush();
        bf.close();
        bw.close();
    }
 
}