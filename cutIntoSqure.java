import java.util.*;
class main{
    static int solve(int a,int b){
        a=Math.min(a,b);
        b=Math.max(a,b);
        int n=a*b;
        int count=0;
        while(n>0 && a>=1){
            if(a*a<=n){
                
                n-=a*a;
    
                count++;
            }else{
                a--;
            }
            
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(solve(36,30));
    }
}