import java.util.*;
class main{
    
    public static void main(String args[]){
        Scanner scn =  new Scanner(System.in);
        for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
            long a = scn.hasNextLong()?scn.nextLong():0;
            long m = scn.hasNextLong()?scn.nextLong():0;
            long n = m/a;
            ArrayList<Long> res = new ArrayList<>();
            // System.out.println(m+"\t"+"\t"+a+"\t"+n);
            for(long i=1;i<=n;i++){
                long den = a*i+1;
                double d =(float) m/den;
                if(Math.floor(d)==d){
                    res.add((long)d*i);
                    // System.out.println("fill");
                }
            }
            System.out.println(res.size());
            for(long item : res){
                System.out.print(item+"\t");
            }
            System.out.println();
            res.clear();
        }
        // System.out.println(sb);
    }
}