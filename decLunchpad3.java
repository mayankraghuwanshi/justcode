import java.util.*;
class main{
    
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
            int m = scn.hasNextInt()?scn.nextInt():0;
            int a = scn.hasNextInt()?scn.nextInt():0;
            int n = m/a;
            // System.out.println(m+"\t"+a);
            ArrayList<Integer> res = new ArrayList<>();
            for(int i=1;i<=n;i++){
                int den = a*i+1;
                float d =(float) m/den;
                if(Math.floor(d)==d){
                    res.add((int)d*i);
                }
            }
            // System.out.println(res);
            sb.append(res+"\n");
            res.clear();
        }
        System.out.println(sb);
    }
}