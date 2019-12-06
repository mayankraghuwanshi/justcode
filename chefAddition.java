import java.math.BigInteger;
import java.util.*;
class main{
    // static int add(int a , int b){
    //     if(a==0) return 0;
    //     int xor = a^b;
    //     int and = a&b;
    //     return 1+add(and<<1,xor);        
    // }
    // static int add(int a , int b){
    //     int count=0;
    //     while(b>0){
    //         int xor = a^b;
    //         int and = a&b;
    //         b=and<<1;
    //         a=xor;
    //         count++;
    //     }
    //     return count;
    // }
    static int add(BigInteger a , BigInteger b){
        int count=0;
        while(b.compareTo(BigInteger.ZERO)>0){
            BigInteger xor = a.xor(b);
            BigInteger and = a.and(b);
            b=and.shiftLeft(1);
            a=xor;
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StringBuilder res = new StringBuilder();
        for(int tc=scn.hasNextInt()?scn.nextInt():0;tc>0;tc--){
            String s1 = scn.hasNext()?scn.next():"";
            String s2 = scn.hasNext()?scn.next():"";         
            // System.out.println("res  "+n1+"\t"+n2);
            // res.append(add(n1, n2)+"\n");
            res.append(add(new BigInteger(s1),new BigInteger(s2))+"\n");
        }
        System.out.println(res);  
    }
}