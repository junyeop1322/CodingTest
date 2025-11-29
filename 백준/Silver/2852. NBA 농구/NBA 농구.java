import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

        int score[] = new int[3];
        long pTimeMil[] = new long[3];
        long sumTimeMil[] = new long[3];
        boolean maintainWin[] = new boolean[3];

        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;++i){
            st=new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            Date date = sdf.parse(st.nextToken());
            
            long cTimeMil=date.getTime()+32400000;

            ++score[team];
            
            if(score[1]>score[2] && team==1 && maintainWin[1]==false){
                pTimeMil[2]=cTimeMil;
                maintainWin[1]=true;
                maintainWin[2]=false;
            } else if(score[1]<score[2] && team==2 && maintainWin[2]==false){
                pTimeMil[1]=cTimeMil;
                maintainWin[2]=true;
                maintainWin[1]=false;
            } else if(score[1]==score[2]){
                if(team==1){
                    sumTimeMil[2]+=(cTimeMil-pTimeMil[1]);
                }
                else{
                    sumTimeMil[1]+=(cTimeMil-pTimeMil[2]);
                }
                maintainWin[1]=false;
                maintainWin[2]=false;
            }
        }
        
        Date date = sdf.parse("48:00");
        long cTimeMil=date.getTime()+32400000;
        if(score[1]>score[2]){
            sumTimeMil[1]+=(cTimeMil-pTimeMil[2]);
        }
        else if(score[1]<score[2]){
            sumTimeMil[2]+=(cTimeMil-pTimeMil[1]);
        }

        Date timeInDate = new Date(sumTimeMil[1]);
        System.out.println(sdf.format(timeInDate));
        Date timeInDate2 = new Date(sumTimeMil[2]);
        System.out.println(sdf.format(timeInDate2));
    }
}