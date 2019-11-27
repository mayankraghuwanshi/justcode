import java.util.*;
class test{
    static void solve(int n , char src , char dest , char helper){
        if(n==0){
            return ;
        }
        solve(n-1, src, helper, dest);
        System.out.println("moving "+n+"th disk from "+src+" to "+dest);
        solve(n-1, helper, dest, src);

    }
    public static void main(String args[]){
        int n=3;
        solve(3,'a', 'b','c');;

    }
}