import java.io.*;

public class Main {

    static boolean whatIsLanguage = false;
    static boolean allOfLower = true;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        if(!(is_Cpp(sb) && is_Java(sb) && name_check(sb))){
            System.out.println("Error!");
            return;
        }

        if(allOfLower){
            System.out.println(sb.toString());
            return;
        }

        if(whatIsLanguage) sb = javaToCpp(sb);
        else sb = cppToJava(sb);

        System.out.println(sb.toString());

    }

    public static boolean name_check(StringBuilder sb){
        int isUpperCase = 0;
        int isUnderBar = 0;

       for(int i=0; i < sb.length(); i++){
           char ch = sb.charAt(i);

           if(ch >= 'A' && ch <= 'Z') isUpperCase = 1;
           else if(ch == '_') isUnderBar = 1;
       }

       allOfLower = (isUnderBar == 1 || isUpperCase == 1) ? false : true;

       if((isUnderBar & isUpperCase) == 0 || allOfLower) {
           whatIsLanguage = (isUnderBar == 1) ? false : true;
           return true;
       }else return false;

    }

    public static boolean is_Cpp(StringBuilder sb){
        if(sb.charAt(sb.length()-1) == '_') return false;
        else if(sb.charAt(0) == '_') return false;
        else if(sb.indexOf("__") >= 0) return false;

        return true;
    }

    public static boolean is_Java(StringBuilder sb){
        return (sb.charAt(0) >= 'A'&& sb.charAt(0) <= 'Z') ? false : true;
    }

    public static StringBuilder javaToCpp(StringBuilder sb){
        for(int i=0; i<sb.length(); i++){
            char ch = sb.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                sb.replace(i, i+1, String.valueOf(ch).toLowerCase());
                sb.insert(i, "_");
            }
        }
        return sb;
    }

    public static StringBuilder cppToJava(StringBuilder sb){
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '_'){
                sb.deleteCharAt(i);
                sb.replace(i+1, i+1, String.valueOf(sb.charAt(i)).toUpperCase());
                sb.deleteCharAt(i);
            }
        }
        return sb;
    }



}