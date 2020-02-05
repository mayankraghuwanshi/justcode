import java.util.*;
import java.math.BigInteger;
class StringInteger{
    String val;
    StringInteger(int num){
        this.val = String.valueOf(num);
    }

    int mod(int num){
        int r=0;
        String s = this.val;
        for(int i=0;i<s.length();i++){
            int lastInt = s.charAt(i)-'0';
            r=r*10+lastInt;
            r%=num;
        }
        return r;
    }
}

class main{
    public static void main(String args[]){
        StringInteger n = new StringInteger(21);
        System.out.println(n.mod(4));
    }
}