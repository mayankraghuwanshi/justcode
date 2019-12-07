import java.util.*;
import java.math.*;
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
        System.out.println(a.intValue());
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        for(int tc=scn.hasNextInt()? scn.nextInt():0;tc>0;tc--){
            String s1 = scn.hasNext()?scn.next():"";
            String s2 = scn.hasNext()?scn.next():"";
            int res = add(new BigInteger(s1,2),new BigInteger(s2,2));
            output.append(res+"\n");
        }
        System.out.println(output);
    }
}