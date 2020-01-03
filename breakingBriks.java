import java.util.*;
class main{
    public static void main (String args[]) {
		Scanner scn = new Scanner(System.in);
		for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
            int s = scn.hasNextInt()?scn.nextInt():0;
            int w[] = new int[3];
            for(int i=0;i<3;i++){
                w[i]=scn.hasNextInt()?scn.nextInt():0;
            }
            for(int i=1;i<3;i++){
                if(w[i]+w[i-1]<=s){
                    w[i]=w[i]+w[i-1];
                    w[i-1]=-1;
                }
            }
            int res=0;
            for(int item : w){
                if(item>0){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
