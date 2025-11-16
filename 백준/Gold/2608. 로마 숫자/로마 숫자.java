import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String,Integer> roma = new HashMap<>();
    static HashMap<String, Integer> romaCount = new HashMap<>();
    static String[] priority = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    static int numA;
    static int numB;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String romaA = A;
        String romaB = B;

        if(romaA.equals("") && romaB.equals("")){
            System.out.println(0);
            System.out.println();
            return;
        }
        roma.put("M",1000);
        romaCount.put("M",3);

        roma.put("CM",900);
        romaCount.put("CM",1);

        roma.put("D",500);
        romaCount.put("D",1);

        roma.put("CD",400);
        romaCount.put("CD",1);

        roma.put("C",100);
        romaCount.put("C",3);

        roma.put("XC",90);
        romaCount.put("XC",1);

        roma.put("L",50);
        romaCount.put("L",1);

        roma.put("XL",40);
        romaCount.put("XL",1);

        roma.put("X",10);
        romaCount.put("X",3);

        roma.put("IX",9);
        romaCount.put("IX",1);

        roma.put("V",5);
        romaCount.put("V",1);

        roma.put("IV",4);
        romaCount.put("IV",4);

        roma.put("I",1);
        romaCount.put("I",3);
        if(!romaA.equals("")) {
            if (romaA.contains("CM")) {
                numA += 900;
                romaA = romaA.replace("CM", "");
            } else if (romaA.contains("CD")) {
                numA += 400;
                romaA = romaA.replace("CD", "");
            }
            if (romaA.contains("XC")) {
                numA += 90;
                romaA = romaA.replace("XC", "");
            } else if (romaA.contains("XL")) {
                numA += 40;
                romaA = romaA.replace("XL", "");
            }

            if (romaA.contains("IX")) {
                numA += 9;
                romaA = romaA.replace("IX", "");
            } else if (romaA.contains("IV")) {
                numA += 4;
                romaA = romaA.replace("IV", "");
            }

            if(!romaA.equals("")) {
                for (String a : romaA.split("")) {
                    numA += roma.get(a);
                }
            }
        }

        if(!romaB.equals("")) {
            if (romaB.contains("CM")) {
                numB += 900;
                romaB = romaB.replace("CM", "");
            } else if (romaB.contains("CD")) {
                numB += 400;
                romaB = romaB.replace("CD", "");
            }

            if (romaB.contains("XC")) {
                numB += 90;
                romaB = romaB.replace("XC", "");
            } else if (romaB.contains("XL")) {
                numB += 40;
                romaB = romaB.replace("XL", "");
            }

            if (romaB.contains("IX")) {
                numB += 9;
                romaB = romaB.replace("IX", "");
            } else if (romaB.contains("IV")) {
                numB += 4;
                romaB = romaB.replace("IV", "");
            }

            if(!romaB.equals("")) {
                for (String a : romaB.split("")) {
                    numB += roma.get(a);
                }
            }
        }
        if(A.equals("")){
            System.out.println(numB);
            System.out.println(B);
            return;
        }
        if(B.equals("")){
            System.out.println(numA);
            System.out.println(A);
            return;
        }

        System.out.println(numA + numB);
        StringBuilder sb = new StringBuilder();
        int sum = numA + numB;
        while(sum != 0){
            for(String romaWord : priority){
                if(sum - roma.get(romaWord) >=0 && romaCount.get(romaWord) > 0){
                    sum -= roma.get(romaWord);
                    sb.append(romaWord);
                    romaCount.put(romaWord, romaCount.get(romaWord) - 1);
                    if(romaWord.equals("CM")){
                        romaCount.put("CD", 0);
                    }else if(romaWord.equals("CD")){
                        romaCount.put("CM", 0);
                    }else if(romaWord.equals("XC")){
                        romaCount.put("XL", 0);
                    }else if(romaWord.equals("XL")){
                        romaCount.put("XC", 0);
                    }else if(romaWord.equals("IX")){
                        romaCount.put("IV", 0);
                    }else if(romaWord.equals("IV")){
                        romaCount.put("IX", 0);
                    }
                    break;
                }
            }
        }
        System.out.println(sb);
    }

}